package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 生产流程步骤
 * 工厂页展示生产全流程
 */
@Data
public class ProductionStep {

    private Long id;                  // 主键
    private Integer stepNumber;       // 步骤序号（1, 2, 3...）
    private String stepName;          // 步骤名称（如：需求沟通）
    private String description;       // 步骤描述
    private String icon;              // 图标标识
    private Integer sortOrder;        // 排序
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
