package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 产品多图
 */
@Data
public class ProductImage {

    private Long id;                  // 主键
    private Long productId;           // 所属产品 ID
    private String imageUrl;          // 图片 URL
    private String label;             // 图片标签（主视图/细节图/场景图）
    private Integer sortOrder;        // 排序
    private LocalDateTime createTime; // 上传时间
}
