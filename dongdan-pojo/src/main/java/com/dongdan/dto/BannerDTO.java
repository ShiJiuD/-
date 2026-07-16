package com.dongdan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Banner 新增 / 编辑请求体
 */
@Data
public class BannerDTO {

    @NotBlank(message = "标题不能为空")
    private String title;

    private String subtitle;

    private String imageUrl;     // 允许先创建后上传图片

    private String imageKeyword;

    private String linkUrl;

    private Integer sortOrder = 0;
}