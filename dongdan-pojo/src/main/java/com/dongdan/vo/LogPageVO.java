package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LogPageVO {
    private Long id;
    private String adminName;       // admin_name → adminName
    private String operation;
    private String targetType;      // target_type → targetType
    private String ip;
    private LocalDateTime createTime;
}