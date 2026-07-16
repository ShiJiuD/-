package com.dongdan.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 产品分页查询请求体
 */
@Data
public class ProductPageQueryDTO {

    private String keyword;   // 搜索关键词（产品名称）
    @NotNull(message = "页码不能为空")
    private Integer page;     // 页码，默认 1
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize; // 每页条数，默认 10
    private Long categoryId;  // 分类筛选（可选）
}