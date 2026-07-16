package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.ChangePasswordDTO;
import com.dongdan.dto.LoginDTO;
import com.dongdan.entity.AdminUser;
import com.dongdan.exception.AccountLockedException;
import com.dongdan.exception.AccountNotFoundException;
import com.dongdan.exception.PasswordErrorException;
import com.dongdan.mapper.AdminUserMapper;
import com.dongdan.service.AdminUserService;
import com.dongdan.utils.JwtUtil;
import com.dongdan.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserMapper adminUserMapper;
    private final JwtUtil jwtUtil;

    @Override
    public LoginVO login(LoginDTO dto) {
        log.info("管理员登录请求：{}", dto);
        // 拿到用户名和密码
        String username = dto.getUsername();
        String password = dto.getPassword();
        AdminUser adminUser = adminUserMapper.getByUserName(username);

        // 校验账号是否存在
        if (adminUser == null) {
            throw new AccountNotFoundException();
        }
        // 校验密码是否正确
        if (!BCrypt.checkpw(password, adminUser.getPassword())) {
            throw new PasswordErrorException();
        }
        // 校验账号是否启用
        if (adminUser.getStatus() == 0) {
            throw new AccountLockedException();
        }

        // 生成 JWT 令牌
        String token = jwtUtil.generateToken(adminUser.getId(), adminUser.getUsername());

        return LoginVO.builder()
                .id(adminUser.getId())
                .username(adminUser.getUsername())
                .nickname(adminUser.getNickname())
                .token(token)
                .build();
    }

    @Override
    public AdminUser getById(Long id) {
        AdminUser user = adminUserMapper.getById(id);
        if (user == null) {
            throw new AccountNotFoundException();
        }
        return user;
    }

    @Override
    public void changePassword(Long userId, ChangePasswordDTO dto) {
        AdminUser user = adminUserMapper.getById(userId);
        if (user == null) {
            throw new AccountNotFoundException();
        }

        // 校验旧密码
        if (!BCrypt.checkpw(dto.getOldPassword(), user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.OLD_PASSWORD_ERROR);
        }

        // 加密新密码并更新
        String newHash = BCrypt.hashpw(dto.getNewPassword(), BCrypt.gensalt());
        adminUserMapper.updatePassword(userId, newHash);
        log.info("管理员 {} 修改密码成功", user.getUsername());
    }
}
