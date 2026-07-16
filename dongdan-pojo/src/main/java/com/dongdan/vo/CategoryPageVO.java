package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 管理端分类列表项 — 含产品数量
 */
@Data
public class CategoryPageVO {

    private Long id;
    private String name;
    private String icon;            // 线性图标 key（VARCHAR(50)）
    private Integer sortOrder;
    private Integer isVisible;      // 1=显示 0=隐藏
    private Integer productCount;   // COUNT 来的
    private LocalDateTime createTime;
}