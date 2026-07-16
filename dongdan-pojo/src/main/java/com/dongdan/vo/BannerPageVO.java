package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Banner 管理端列表项
 * 比公开 BannerVO（D2 创建）多了管理字段
 */
@Data
public class BannerPageVO {
    private Long id;
    private String title;
    private String subtitle;
    private String imageUrl;         // image_url → imageUrl
    private String imageKeyword;     // image_keyword → imageKeyword
    private String linkUrl;          // link_url → linkUrl
    private Integer sortOrder;       // sort_order → sortOrder
    private Integer isVisible;       // is_visible → isVisible
    private LocalDateTime createTime;
}