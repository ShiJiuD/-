package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 工厂信息（单行记录）
 */
@Data
public class FactoryInfo {

    private Long id;                   // 主键
    private String companyName;        // 公司全称
    private String shortName;          // 公司简称
    private String establishedYear;    // 成立年份
    private String factoryArea;        // 厂房面积
    private String employeeCount;      // 员工数
    private String dailyCapacity;      // 日产能
    private String mainBusiness;       // 主营业务描述
    private String factoryImageUrl;    // 工厂全景图 URL
    private String factoryImageKeyword;// 图片替换关键词
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间
}
