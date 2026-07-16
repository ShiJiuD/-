package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 系统配置（KV 键值对）
 * 首页数据 + 联系方式统一存这里，后台可修改
 */
@Data
public class SystemConfig {

    private Long id;                  // 主键
    private String configKey;         // 配置键名（程序读取用）
    private String configValue;       // 配置值
    private String configDesc;        // 配置说明（后台显示的提示文字）
    private String configType;        // 值类型：text / number / image / richtext
    private Integer sortOrder;        // 排序
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
