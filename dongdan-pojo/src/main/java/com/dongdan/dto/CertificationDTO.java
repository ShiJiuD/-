package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 认证新增 / 编辑请求体
 */
@Data
public class CertificationDTO {

    @NotBlank(message = "认证名称不能为空")
    private String name;

    private String imageUrl;

    private String imageKeyword;

    private Integer sortOrder;

    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;
}
