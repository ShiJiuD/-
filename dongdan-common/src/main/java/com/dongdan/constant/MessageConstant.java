package com.dongdan.constant;

/**
 * 全局提示信息常量
 * 所有异常、返回结果的 message 统一从这里取，不硬编码字符串
 */
public class MessageConstant {

    // ===== 登录认证相关 =====
    public static final String ACCOUNT_NOT_FOUND = "账号不存在";
    public static final String PASSWORD_ERROR    = "用户名或密码错误";
    public static final String OLD_PASSWORD_ERROR = "旧密码错误";
    public static final String ACCOUNT_LOCKED    = "账号已被禁用，请联系管理员";
    public static final String NOT_LOGIN         = "未登录或 token 已过期";

    // ===== 资源不存在 =====
    public static final String PRODUCT_NOT_FOUND   = "产品不存在或已下架";
    public static final String CATEGORY_NOT_FOUND  = "分类不存在";
    public static final String BANNER_NOT_FOUND    = "Banner 不存在";
    public static final String CASE_NOT_FOUND      = "案例不存在";
    public static final String INQUIRY_NOT_FOUND   = "询价记录不存在";
    public static final String CERT_NOT_FOUND      = "认证不存在";
    public static final String FAQ_NOT_FOUND       = "问答不存在";
    public static final String SETTING_NOT_FOUND   = "配置项不存在";
    public static final String PRODUCT_DELETE_ERROR = "至少选择一个产品";
    public static final String CATEGORY_DELETE_ERROR_WITH_PRODUCT = "分类下有产品，不能删除";

    // ===== 操作结果 =====
    public static final String OPERATION_OK   = "操作成功";
    public static final String SAVE_OK        = "保存成功";
    public static final String DELETE_OK      = "删除成功";
    public static final String INQUIRY_OK     = "询价提交成功";
    public static final String UPLOAD_OK      = "上传成功";

    // ===== 操作失败 =====
    public static final String UPLOAD_FAILED  = "文件上传失败";
    public static final String DELETE_FAILED  = "删除失败";
    public static final String UNKNOWN_ERROR  = "服务器内部错误";
    public static final String NEWS_NOT_FOUND = "新闻不存在";
}
