package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 客户案例列表项（公开）
 * customer_case 表字段自动驼峰映射
 */
@Data
public class CaseVO {
    private Long id;
    private String clientName;       // client_name → clientName
    private String industry;
    private String description;
    private String highlight;        // 亮点介绍
    private String imageUrl;         // image_url → imageUrl
    private String imageKeyword;     // image_keyword → imageKeyword
    private String products;         // JSON 数组字符串，前端 JSON.parse
    private Integer quantity;
    private Integer sortOrder;       // sort_order → sortOrder
    private LocalDateTime createTime;
}