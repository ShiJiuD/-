package com.dongdan.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * 分类分页查询参数
 */
@Data
public class CategoryPageQueryDTO {

    /**
     * 分页页码
     */
    @Min(value = 1, message = "分页页码不能小于1")
    private Integer page = 1;
    /**
     * 分页每页数量
     */
    @Min(value = 1, message = "分页每页数量不能小于1")
    private Integer pageSize = 10;
    private String keyword;   // 搜索分类名（可选）
}