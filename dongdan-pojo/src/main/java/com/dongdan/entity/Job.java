package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 招聘信息（扩展预留）
 */
@Data
public class Job {

    private Long id;                  // 主键
    private String title;             // 职位名称
    private String department;        // 所属部门
    private String location;          // 工作地点
    private String salary;            // 薪资范围
    private Integer quantity;         // 招聘人数
    private String requirements;      // 岗位要求（富文本）
    private Integer isVisible;        // 1=招聘中 0=已关闭
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
