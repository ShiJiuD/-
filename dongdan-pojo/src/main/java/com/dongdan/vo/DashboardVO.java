package com.dongdan.vo;

import lombok.Data;

/**
 * 工作台统计数据
 */
@Data
public class DashboardVO {

    private Integer productCount;   // 产品总数
    private Integer inquiryCount;   // 待处理询价数
    private Integer bannerCount;    // Banner 数量
    private Integer todayVisits;    // 今日访问量
}
