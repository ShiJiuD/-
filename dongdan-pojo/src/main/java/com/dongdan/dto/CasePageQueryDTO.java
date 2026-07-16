package com.dongdan.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CasePageQueryDTO {

    @Min(value = 1)
    private Integer page = 1;

    @Min(value = 1)
    private Integer pageSize = 20;

    /** 客户名称 / 行业 关键词搜索 */
    private String keyword;
}