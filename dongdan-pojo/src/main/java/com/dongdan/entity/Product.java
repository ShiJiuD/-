package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 产品（核心表）
 * 规则：字段填了就显示，不填前端自动隐藏对应行
 */
@Data
public class Product {

    private Long id;                  // 主键
    private Long categoryId;          // 所属分类 ID
    private String name;              // 产品名称
    private String coverImage;        // 封面图 URL
    private String imageKeyword;      // 图片替换关键词
    private String material;          // 材质（如：纯棉斜纹）
    private Integer moq;              // 最小起订量（件）
    private String priceHint;         // 价格提示文字（如：面议）
    private String description;       // 产品描述
    private Integer isVisible;        // 1=上架 0=下架
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer viewCount;        // 浏览次数
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
