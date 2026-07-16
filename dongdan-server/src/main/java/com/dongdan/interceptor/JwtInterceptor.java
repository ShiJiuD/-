package com.dongdan.interceptor;

import com.dongdan.context.AdminContext;
import com.dongdan.service.TokenBlacklistService;
import com.dongdan.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;
    private final TokenBlacklistService tokenBlacklistService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;  // 非 Controller 请求（如静态资源）直接放行
        }
        // 从请求头中获取 token 参数
        String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
            log.info("token is null or not start with Bearer");
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":0,\"msg\":\"未登录或 token 已过期\"}");
            return false;
        }
        // 从 tokenHeader 中获取 token
        String token = tokenHeader.substring(7);

        // ===== 黑名单校验：已退出的 token 直接拒绝 =====
        if (tokenBlacklistService.isBlacklisted(token)) {
            log.info("token 已被作废（已退出登录）");
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":0,\"msg\":\"token 已作废，请重新登录\"}");
            return false;
        }

        // 验证 token 是否有效
        if (!jwtUtil.isValid(token)) {
            log.info("token is not valid");
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":0,\"msg\":\"未登录或 token 已过期\"}");
            return false;
        }
        // 从 token 中获取 userId，设置 AdminContext
        Long userId = jwtUtil.getUserId(token);
        AdminContext.setAdminId(userId);
        String username = jwtUtil.getUsername(token);
        AdminContext.setAdminName(username);

        return true;
    }

    // 清除 AdminContext，必须在 afterCompletion 中调用，防止线程池复用导致串号
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        AdminContext.clear();
    }
}
