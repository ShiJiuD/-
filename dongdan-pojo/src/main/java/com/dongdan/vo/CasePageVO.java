package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 客户案例管理端列表项 — 比 CaseVO 多了 isVisible
 */
@Data
public class CasePageVO {
    private Long id;
    private String clientName;
    private String industry;
    private String description;
    private String highlight;
    private String imageUrl;
    private String imageKeyword;
    private String products;         // JSON 字符串
    private Integer quantity;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
}