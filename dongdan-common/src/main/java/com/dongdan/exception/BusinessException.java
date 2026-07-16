package com.dongdan.exception;

/**
 * 通用业务异常（兜底） — 无法归类时使用
 *
 * 示例场景：
 *   - 询价提交时参数校验失败
 *   - 批量删除时选中数量为 0
 *   - 产品 MOQ 不在合理范围内
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
