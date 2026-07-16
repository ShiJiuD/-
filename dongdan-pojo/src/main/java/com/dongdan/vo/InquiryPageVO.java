package com.dongdan.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理端询价列表项
 * 字段名全部和数据库自动驼峰对齐
 */
@Data
public class InquiryPageVO {
    private Long id;
    private String inquiryCode;      // inquiry_code 自动驼峰
    private String companyName;      // company_name 自动驼峰
    private String contactName;      // contact_name 自动驼峰
    private String phone;
    private String productCategory;  // product_category 自动驼峰
    private String quantity;         // quantity 预计数量
    private Integer status;          // 数字状态码 0/1/2/3
    private String statusText;       // 中文状态，Service 层写入
    private LocalDateTime createTime;       // MyBatis 驼峰映射 + Jackson 自动序列化
}