package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 常见问答
 */
@Data
public class Faq {
    private Long id;
    private String question;
    private String answer;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
