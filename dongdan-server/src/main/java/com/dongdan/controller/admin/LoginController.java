package com.dongdan.controller.admin;

import com.dongdan.dto.ChangePasswordDTO;
import com.dongdan.dto.LoginDTO;
import com.dongdan.entity.AdminUser;
import com.dongdan.exception.UnauthorizedException;
import com.dongdan.result.Result;
import com.dongdan.service.AdminUserService;
import com.dongdan.service.TokenBlacklistService;
import com.dongdan.utils.JwtUtil;
import com.dongdan.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "管理员认证")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final AdminUserService adminUserService;
    private final JwtUtil jwtUtil;
    private final TokenBlacklistService tokenBlacklistService;

    // ===== 原有：登录 =====

    @Operation(summary = "管理员登录")
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO dto) {
        log.info("管理员登录请求：{}", dto);
        LoginVO vo = adminUserService.login(dto);
        return Result.success(vo);
    }

    // ===== Day 7 新增：刷新 Token =====

    @Operation(summary = "刷新 Token")
    @PostMapping("/refresh")
    public Result<Map<String, String>> refresh(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new UnauthorizedException("未登录");
        }
        String oldToken = header.substring(7);

        // 黑名单校验：已退出的 token 不能刷新
        if (tokenBlacklistService.isBlacklisted(oldToken)) {
            throw new UnauthorizedException("Token 已作废，请重新登录");
        }

        if (!jwtUtil.isValid(oldToken)) {
            throw new UnauthorizedException("Token 已过期");
        }
        Long userId = jwtUtil.getUserId(oldToken);
        String username = jwtUtil.getUsername(oldToken);

        // 旧 token 加入黑名单，防止被复用
        long remainingTtl = jwtUtil.getRemainingTtl(oldToken);
        if (remainingTtl > 0) {
            tokenBlacklistService.blacklist(oldToken, remainingTtl);
        }

        String newToken = jwtUtil.generateToken(userId, username);
        Map<String, String> data = new HashMap<>();
        data.put("accessToken", newToken);
        return Result.success(data);
    }

    // ===== Day 7 新增：当前用户 =====

    @Operation(summary = "当前用户信息")
    @GetMapping("/current-admin")
    public Result<Map<String, Object>> currentAdmin(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        Long userId = jwtUtil.getUserId(token);
        AdminUser user = adminUserService.getById(userId);
        Map<String, Object> data = new HashMap<>();
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("nickname", user.getNickname());
        return Result.success(data);
    }

    // ===== 修改密码 =====

    @Operation(summary = "修改当前管理员密码")
    @PutMapping("/password")
    public Result changePassword(@Valid @RequestBody ChangePasswordDTO dto,
                                  HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        Long userId = jwtUtil.getUserId(token);

        adminUserService.changePassword(userId, dto);

        // 密码修改后，将旧 token 加入黑名单，强制重新登录
        long remainingTtl = jwtUtil.getRemainingTtl(token);
        if (remainingTtl > 0) {
            tokenBlacklistService.blacklist(token, remainingTtl);
        }

        log.info("用户 {} 密码已修改，旧 token 已作废", userId);
        return Result.success();
    }

    // ===== 退出登录：Token 加入 Redis 黑名单 =====

    @Operation(summary = "退出登录")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            return Result.success();
        }
        String token = header.substring(7);
        long remainingTtl = jwtUtil.getRemainingTtl(token);
        if (remainingTtl > 0) {
            tokenBlacklistService.blacklist(token, remainingTtl);
            log.info("用户已退出登录，token 加入黑名单，剩余 TTL={}ms", remainingTtl);
        }
        return Result.success();
    }
}
