package com.dongdan.exception;

/**
 * 资源不存在 — 用户端 + 商家端均可能触发
 *
 * 用户端：GET /api/products/{id} → 产品不存在
 * 商家端：GET /api/admin/products/{id} → 编辑回显时产品已被删除
 */
public class ResourceNotFoundException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
