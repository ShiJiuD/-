package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 新闻资讯（扩展预留）
 */
@Data
public class News {

    private Long id;                   // 主键
    private String categoryName;       // 新闻分类
    private String title;              // 标题
    private String summary;            // 摘要
    private String content;            // 正文（富文本）
    private String coverImage;         // 封面图 URL
    private String source;             // 来源
    private Integer viewCount;         // 浏览次数
    private Integer isVisible;         // 1=发布 0=隐藏
    private LocalDateTime publishTime; // 发布时间
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间
}
