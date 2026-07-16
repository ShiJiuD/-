package com.dongdan.vo;

import lombok.Data;

/**
 * 首页优势卡片 — 字段名和前端 Advantage 类型对齐
 */
@Data
public class AdvantageVO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String imageKeyword;    // image_keyword 自动驼峰
}