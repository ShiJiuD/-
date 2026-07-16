package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 认证管理端列表项 — 比 CertificationVO 多了 sortOrder + isVisible + createTime
 */
@Data
public class CertificationPageVO {
    private Long id;
    private String name;
    private String imageUrl;
    private String imageKeyword;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
}
