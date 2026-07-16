package com.dongdan.entity;

import lombok.Data;

/**
 * 产品规格参数
 * 一个产品可有多条规格（面料/克重/尺码/颜色...）
 */
@Data
public class ProductSpec {

    private Long id;             // 主键
    private Long productId;      // 所属产品 ID
    private String specLabel;    // 参数名（如：面料成分）
    private String specValue;    // 参数值（如：100%纯棉）
    private Integer sortOrder;   // 排序
}
