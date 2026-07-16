package com.dongdan.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${dongdan.jwt.secret}")
    private String secret;

    @Value("${dongdan.jwt.expiration}")
    private Long expiration;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /** 生成 token */
    public String generateToken(Long userId, String username) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey())
                .compact();
    }

    /** 解析 token */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /** 验证 token 是否有效 */
    public boolean isValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 从 token 中获取 userId */
    public Long getUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    /** 从 token 中获取 username */
    public String getUsername(String token) {
        return parseToken(token).get("username", String.class);
    }

    /** 获取 token 剩余有效时间（毫秒），已过期返回 0 */
    public long getRemainingTtl(String token) {
        try {
            Claims claims = parseToken(token);
            // claims.getExpiration() 返回的是过期时间点，需要转换为毫秒级
            long remaining = claims.getExpiration().getTime() - System.currentTimeMillis();
            return Math.max(remaining, 0);
        } catch (Exception e) {
            return 0;
        }
    }
}
