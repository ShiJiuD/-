package com.dongdan.vo;

import lombok.Data;

/**
 * FAQ 公开列表项
 */
@Data
public class FaqVO {
    private Long id;
    private String question;
    private String answer;
    private Integer sortOrder;
}
