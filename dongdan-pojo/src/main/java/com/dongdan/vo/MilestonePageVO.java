package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 发展历程管理端列表项 — 比 MilestoneVO 多了 isVisible / createTime
 */
@Data
public class MilestonePageVO {
    private Long id;
    private String year;
    private String description;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
}
