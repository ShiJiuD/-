package com.dongdan.context;

/**
 * ThreadLocal 持有当前登录管理员信息
 * JwtInterceptor preHandle 设置，afterCompletion 清除
 */
public class AdminContext {

    private static final ThreadLocal<Long> ADMIN_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> ADMIN_NAME = new ThreadLocal<>();

    public static void setAdminId(Long id) {
        ADMIN_ID.set(id);
    }

    public static Long getAdminId() {
        return ADMIN_ID.get();
    }

    public static void setAdminName(String name) {
        ADMIN_NAME.set(name);
    }

    public static String getAdminName() {
        return ADMIN_NAME.get();
    }

    /** 清除 — 必须在 afterCompletion 中调用，防止线程池复用导致串号 */
    public static void clear() {
        ADMIN_ID.remove();
        ADMIN_NAME.remove();
    }
}