package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 首页 Banner 轮播
 */
@Data
public class Banner {

    private Long id;                  // 主键
    private String title;             // 标题
    private String subtitle;          // 副标题
    private String imageUrl;          // 图片 URL
    private String imageKeyword;      // 图片替换关键词
    private String linkUrl;           // 点击跳转链接
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
