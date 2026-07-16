package com.dongdan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 询价提交请求体
 * 用户端提交，无需登录
 */
@Data
public class InquirySubmitDTO {

    private String companyName;         // 公司名称（选填）

    @NotBlank(message = "联系人不能为空")
    private String contactName;         // 联系人（必填）

    @NotBlank(message = "电话不能为空")
    private String phone;               // 联系电话（必填）

    @Email(message = "邮箱格式不正确")
    private String email;               // 邮箱（选填）

    @NotBlank(message = "品类不能为空")
    private String productCategory;     // 产品品类（必填）

    @NotBlank(message = "数量不能为空")
    private String quantity;            // 预计数量（必填）

    private String description;         // 需求描述（选填）
}
