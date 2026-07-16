package com.dongdan.exception;

import com.dongdan.constant.MessageConstant;

/**
 * 密码错误 — 仅商家端登录 / 改密时触发
 */
public class PasswordErrorException extends BaseException {

    private static final long serialVersionUID = 1L;

    public PasswordErrorException() {
        super(MessageConstant.PASSWORD_ERROR);
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }
}
