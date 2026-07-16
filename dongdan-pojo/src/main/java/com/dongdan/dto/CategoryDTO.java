package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 分类新增 / 编辑请求体
 */
@Data
public class CategoryDTO {

    @NotBlank(message = "分类名称不能为空")
    private String name;        // 分类名称
    private String icon;        // 图标标识
    private Integer sortOrder;  // 排序
    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;  // 是否显示：1=显示 0=隐藏
}
