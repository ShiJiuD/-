package com.dongdan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 新闻新增 / 编辑请求体
 */
@Data
public class NewsDTO {

    @NotBlank(message = "标题不能为空")
    private String title;

    private String summary;

    private String content;          // 富文本正文

    private String coverImage;       // 封面图 URL

    private String source;           // 来源（公司新闻/行业动态/媒体报道）

    private String categoryName;     // 新闻分类

    private Integer isVisible;       // 1=发布 0=隐藏

    private LocalDateTime publishTime;
}