package com.dongdan.service.Impl;

import com.dongdan.service.TokenBlacklistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor

@Slf4j
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private static final String BLACKLIST_PREFIX = "token:blacklist:";

    private final StringRedisTemplate stringRedisTemplate;

    /** 将 token 加入黑名单，ttlMillis 后自动过期 */
    @Override
    public void blacklist(String token, long ttlMillis) {
        try {
            String key = BLACKLIST_PREFIX + token;
            stringRedisTemplate.opsForValue().set(key, "1", ttlMillis, TimeUnit.MILLISECONDS);
            log.info("Token 已加入黑名单，TTL={}ms", ttlMillis);
        } catch (Exception e) {
            log.error("Token 黑名单写入失败（Redis 不可用）：{}", e.getMessage());
        }
    }

    /** 检查 token 是否在黑名单中 */
    @Override
    public boolean isBlacklisted(String token) {
        try {
            String key = BLACKLIST_PREFIX + token;
            return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
        } catch (Exception e) {
            log.error("Token 黑名单查询失败（Redis 不可用）：{}", e.getMessage());
            return false; // Redis 挂了就放行，不影响正常业务
        }
    }

    /** 从黑名单中移除（一般不需要，Redis 会自动过期） */
    @Override
    public void remove(String token) {
        try {
            String key = BLACKLIST_PREFIX + token;
            stringRedisTemplate.delete(key);
        } catch (Exception e) {
            log.error("Token 黑名单删除失败：{}", e.getMessage());
        }
    }
}
