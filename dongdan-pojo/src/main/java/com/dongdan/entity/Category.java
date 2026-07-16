package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 产品分类
 */
@Data
public class Category {

    private Long id;                  // 主键
    private String name;              // 分类名称
    private String icon;              // 图标标识
    private Long parentId;            // 父分类 ID（预留）
    private Integer sortOrder;        // 排序（越小越靠前）
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
