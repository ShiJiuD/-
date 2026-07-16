package com.dongdan.service;

/**
 * Token 黑名单服务 — 基于 Redis
 * 退出登录 / refresh 后旧 token 加入黑名单，过期后 Redis 自动删除
 */
public interface TokenBlacklistService {

    /** 将 token 加入黑名单，ttlMillis 后自动过期 */
    void blacklist(String token, long ttlMillis);

    /** 检查 token 是否在黑名单中 */
    boolean isBlacklisted(String token);

    /** 从黑名单中移除（一般不需要，Redis 会自动过期） */
    void remove(String token);
}
