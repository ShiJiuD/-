package com.dongdan.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * FAQ 管理端分页查询参数
 */
@Data
public class FaqPageQueryDTO {

    @Min(value = 1, message = "分页页码不能小于1")
    private Integer page = 1;

    @Min(value = 1, message = "分页每页数量不能小于1")
    private Integer pageSize = 10;

    private String keyword;
}
