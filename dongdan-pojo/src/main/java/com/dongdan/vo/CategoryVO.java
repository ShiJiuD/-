package com.dongdan.vo;

import lombok.Data;

/**
 * 产品分类 — 返回给前端的数据
 */
@Data
public class CategoryVO {

    private Long id;              // 分类 ID
    private String name;          // 分类名称
    private String icon;          // 图标标识
    private Integer productCount; // 该分类下的产品数量
}
