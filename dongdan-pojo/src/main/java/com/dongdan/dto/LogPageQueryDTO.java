package com.dongdan.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class LogPageQueryDTO {
    @Min(value = 1, message = "分页页码不能小于1")
    private Integer page = 1;
    @Min(value = 1, message = "分页每页数量不能小于1")
    private Integer pageSize = 20;
    private String keyword;       // 操作内容模糊搜索
    private String adminName;     // 操作人筛选
    private String type;          // 目标类型筛选（产品/分类/Banner/优势/新闻/配置/询价/FAQ/认证）
}