package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 生产设备（扩展预留）
 */
@Data
public class Equipment {

    private Long id;                  // 主键
    private String name;              // 设备名称
    private String imageUrl;          // 设备图片 URL
    private String brand;             // 品牌
    private String model;             // 型号
    private Integer quantity;         // 数量
    private String description;       // 说明 / 用途
    private Integer sortOrder;        // 排序
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
