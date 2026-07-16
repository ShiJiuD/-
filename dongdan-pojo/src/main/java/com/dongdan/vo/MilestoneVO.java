package com.dongdan.vo;

import lombok.Data;

/**
 * 发展历程公开列表项 — 无 isVisible / createTime
 */
@Data
public class MilestoneVO {
    private Long id;
    private String year;
    private String description;
    private Integer sortOrder;
}
