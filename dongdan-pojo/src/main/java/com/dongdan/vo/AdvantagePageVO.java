package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 优势管理端列表项
 * 比公开 AdvantageVO（D2 创建）多了管理字段
 */
@Data
public class AdvantagePageVO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;         // image_url → imageUrl
    private String imageKeyword;     // image_keyword → imageKeyword
    private Integer sortOrder;       // sort_order → sortOrder
    private Integer isVisible;       // is_visible → isVisible
    private LocalDateTime createTime;
}