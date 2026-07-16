package com.dongdan.exception;

import com.dongdan.constant.MessageConstant;

/**
 * 账号不存在 — 仅商家端登录时触发
 */
public class AccountNotFoundException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AccountNotFoundException() {
        super(MessageConstant.ACCOUNT_NOT_FOUND);
    }
}
