package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 产品列表项 — 关联查分类名
 */
@Data
public class ProductPageVO {

    private Long id;
    private String name;            // 产品名称
    private String categoryName;    // 分类名称（JOIN 来的）
    private String coverImage;      // 封面图
    private String material;        // 材质
    private Integer moq;            // 最小起订量
    private String priceHint;       // 价格提示
    private Integer isVisible;      // 1=上架 0=下架
    private Integer sortOrder;      // 排序
    private LocalDateTime createTime;
}