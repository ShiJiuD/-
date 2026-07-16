package com.dongdan.vo;

import lombok.Data;

/**
 * 首页精选产品 — 只取卡片展示需要的字段
 */
@Data
public class FeaturedProductVO {

    private Long id;
    private Long categoryId;
    private String name;
    private String image;
    private String material;        // 材质
    private Integer moq;            // 最小起订量
    private String priceHint;
    private String categoryName;
}