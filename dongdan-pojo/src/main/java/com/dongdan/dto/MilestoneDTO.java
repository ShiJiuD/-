package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 发展历程 新增 / 编辑请求体
 */
@Data
public class MilestoneDTO {

    @NotBlank(message = "年份不能为空")
    private String year;

    @NotBlank(message = "描述不能为空")
    private String description;

    private Integer sortOrder = 0;

    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;
}
