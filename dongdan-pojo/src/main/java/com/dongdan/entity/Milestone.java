package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 发展历程
 */
@Data
public class Milestone {
    private Long id;
    private String year;
    private String description;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
