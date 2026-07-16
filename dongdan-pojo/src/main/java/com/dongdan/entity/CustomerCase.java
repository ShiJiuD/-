package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 客户案例
 */
@Data
public class CustomerCase {

    private Long id;                  // 主键
    private String clientName;        // 客户名称
    private String industry;          // 所属行业
    private String description;       // 案例描述
    private String highlight;         // 亮点介绍（一行文字，展示在卡片上）
    private String imageUrl;          // 案例图片 URL
    private String imageKeyword;      // 图片替换关键词
    private String products;          // 供应产品（JSON 数组）
    private Integer quantity;         // 供货数量
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
