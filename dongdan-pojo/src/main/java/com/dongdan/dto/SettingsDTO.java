package com.dongdan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 系统配置保存请求体
 */
@Data
public class SettingsDTO {

    private Integer years;            // 行业深耕（年）
    private Integer clients;          // 累计合作客户
    private Integer dailyCapacity;    // 日产能（件）
    private Integer reorderRate;      // 客户复购率（%）

    @NotBlank(message = "电话不能为空")
    private String phone;             // 公司电话

    @Email(message = "邮箱格式不正确")
    private String email;             // 公司邮箱（选填）
    private String address;           // 公司地址
    private String workHours;         // 工作时间
}
