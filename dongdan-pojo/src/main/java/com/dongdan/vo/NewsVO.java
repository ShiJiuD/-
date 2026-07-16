package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 新闻公开列表项 / 详情
 */
@Data
public class NewsVO {
    private Long id;
    private String title;
    private String summary;
    private String content;          // content → content
    private String coverImage;       // cover_image → coverImage
    private String source;
    private Integer viewCount;       // view_count → viewCount
    private LocalDateTime publishTime;
    private LocalDateTime createTime;
}