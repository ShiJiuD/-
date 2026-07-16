package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 操作日志 — operation_log 表
 */
@Data
public class OperationLog {
    private Long id;
    private Long adminId;           // 操作人 ID
    private String adminName;       // 操作人用户名
    private String operation;       // 操作描述（如：新增产品）
    private String targetType;      // 目标类型（如：产品）
    private Long targetId;          // 目标 ID
    private String description;     // 补充描述
    private String ip;              // 操作 IP
    private LocalDateTime createTime;
}