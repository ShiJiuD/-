package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * FAQ 管理端列表项 — 比 FaqVO 多了 isVisible + createTime
 */
@Data
public class FaqPageVO {
    private Long id;
    private String question;
    private String answer;
    private Integer sortOrder;
    private Integer isVisible;
    private LocalDateTime createTime;
}
