package com.dongdan.vo;

import lombok.Data;

/**
 * 公开产品列表项 — 只含展示字段，不含管理端字段
 */
@Data
public class ProductListVO {

    private Long id;
    private Long categoryId;
    private String name;
    private String image;           // 对齐文档和 ProductVO
    private String imageKeyword;
    private String material;
    private Integer moq;
    private String priceHint;
    private String categoryName;
}