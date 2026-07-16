package com.dongdan.exception;

import com.dongdan.constant.MessageConstant;

/**
 * 未登录或 token 过期 — JWT 拦截器触发
 */
public class UnauthorizedException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super(MessageConstant.NOT_LOGIN);
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
