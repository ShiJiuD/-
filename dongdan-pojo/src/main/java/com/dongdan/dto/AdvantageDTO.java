package com.dongdan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 优势 新增 / 编辑请求体
 */
@Data
public class AdvantageDTO {

    @NotBlank(message = "优势标题不能为空")
    private String title;

    private String description;

    private String imageUrl;

    private String imageKeyword;

    private Integer sortOrder = 0;

    private Integer isVisible;   // 1=显示 0=隐藏，编辑时可同时修改
}