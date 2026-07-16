package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CaseDTO {

    @NotBlank(message = "客户名称不能为空")
    private String clientName;

    private String industry;

    private String description;

    private String highlight;

    private String imageUrl;

    private String imageKeyword;

    /** JSON 数组字符串，如 '["反光背心","工作服"]' */
    private String products;

    private Integer quantity;

    private Integer sortOrder = 0;

    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;
}