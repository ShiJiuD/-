package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 优势亮点
 * 首页"为什么选择我们"区域
 */
@Data
public class Advantage {

    private Long id;                  // 主键
    private String title;             // 优势标题（如：自有工厂·品质可控）
    private String description;       // 优势描述
    private String imageUrl;          // 配图 URL
    private String imageKeyword;      // 图片替换关键词
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
