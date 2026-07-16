package com.dongdan.vo;

import lombok.Data;

/**
 * 首页数据看板 — 4 个数值
 */
@Data
public class HomeStatsVO {

    private Integer years;          // 成立年限（config_key = 'years'）
    private Integer clients;        // 合作客户数（config_key = 'clients'）
    private Integer dailyCapacity;  // 日产能（config_key = 'daily_capacity'）
    private Integer reorderRate;    // 复购率（config_key = 'reorder_rate'）
}