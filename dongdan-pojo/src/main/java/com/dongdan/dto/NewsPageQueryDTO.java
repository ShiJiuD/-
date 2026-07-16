package com.dongdan.dto;

import lombok.Data;

/**
 * 新闻管理端分页查询参数
 */
@Data
public class NewsPageQueryDTO {

    private Integer page = 1;

    private Integer pageSize = 20;

    private String keyword;          // 标题关键词搜索
}