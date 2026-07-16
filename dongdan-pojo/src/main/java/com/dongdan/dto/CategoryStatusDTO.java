package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 分类状态修改DTO
 */
@Data
public class CategoryStatusDTO {

    /**
     * 是否可见 0隐藏 1展示
     */
    @NotNull(message = "状态标识不能为空")
    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;
}