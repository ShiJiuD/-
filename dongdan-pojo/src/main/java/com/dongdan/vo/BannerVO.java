package com.dongdan.vo;

import lombok.Data;

@Data
public class BannerVO {
    private Long id;
    // 数据库 image_url 自动映射 imageUrl
    private String imageUrl;
    // image_keyword → imageKeyword
    private String imageKeyword;
    private String title;
    private String subtitle;
    // link_url → linkUrl
    private String linkUrl;
}