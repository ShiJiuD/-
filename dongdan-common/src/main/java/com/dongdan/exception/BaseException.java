package com.dongdan.exception;

/**
 * 业务异常基类 — 不直接使用，用具体子类抛
 * 继承关系：
 *   BaseException
 *   ├── AccountNotFoundException    账号不存在
 *   ├── PasswordErrorException      密码错误
 *   ├── AccountLockedException      账号被禁用
 *   ├── UnauthorizedException       未登录/token过期
 *   ├── ResourceNotFoundException   资源不存在（产品/分类等）
 *   └── BusinessException           通用业务异常（兜底）
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BaseException(String msg) {
        super(msg);
    }

    /** 保留根因，方便排查问题链 */
    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
