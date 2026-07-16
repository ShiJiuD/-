package com.dongdan.exception;

import com.dongdan.constant.MessageConstant;

/**
 * 账号被禁用 — 仅商家端登录时触发（status=0）
 */
public class AccountLockedException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AccountLockedException() {
        super(MessageConstant.ACCOUNT_LOCKED);
    }
}
