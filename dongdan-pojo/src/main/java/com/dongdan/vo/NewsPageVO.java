package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 新闻管理端列表项 — 比 NewsVO 多了 isVisible
 */
@Data
public class NewsPageVO {
    private Long id;
    private String title;
    private String summary;
    private String content;          // 新闻正文（管理端编辑用）
    private String coverImage;       // cover_image → coverImage
    private String source;
    private String categoryName;     // 分类名称（管理端编辑用）
    private Integer viewCount;       // view_count → viewCount
    private Integer isVisible;       // is_visible → isVisible
    private LocalDateTime publishTime;
    private LocalDateTime createTime;
}