package com.dongdan.aspect;

import com.dongdan.annotation.LogOperation;
import com.dongdan.context.AdminContext;
import com.dongdan.entity.OperationLog;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

/**
 * AOP 切面 — 拦截 @LogOperation 注解的方法
 * 先执行业务，成功后再异步记录日志
 */
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class OperationLogAspect {

    private final LogSaveHelper logSaveHelper;

    @Around("@annotation(logAnno)")
    public Object around(ProceedingJoinPoint joinPoint, LogOperation logAnno) throws Throwable {
        // 1. 先执行业务方法
        Object result = joinPoint.proceed();

        // 2. 异步记录日志 — 失败只打 log，不抛异常
        try {
            OperationLog logEntry = new OperationLog();
            logEntry.setAdminId(AdminContext.getAdminId());
            logEntry.setAdminName(AdminContext.getAdminName());
            logEntry.setOperation(logAnno.value());
            logEntry.setTargetType(logAnno.type());
            logEntry.setCreateTime(LocalDateTime.now());
            logEntry.setIp(getClientIp());
            logSaveHelper.save(logEntry);
        } catch (Exception e) {
            log.error("操作日志写入失败：{}", e.getMessage());
        }

        return result;
    }

    /** 获取客户端 IP */
    private String getClientIp() {
        try {
            ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                HttpServletRequest req = attrs.getRequest();
                String ip = req.getHeader("X-Forwarded-For");
                if (ip == null || ip.isEmpty()) {
                    ip = req.getRemoteAddr();
                }
                return ip;
            }
        } catch (Exception ignored) {}
        return "unknown";
    }
}
