package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 资质认证
 * 工厂页展示 ISO 等证书
 */
@Data
public class Certification {

    private Long id;                  // 主键
    private String name;              // 认证名称（如：ISO 9001）
    private String imageUrl;          // 证书图片 URL
    private String imageKeyword;      // 图片替换关键词
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
