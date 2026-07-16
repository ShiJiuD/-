package com.dongdan.vo;

import lombok.Data;
import java.util.List;

/**
 * Hero Banner 配置 — 4 张轮播图的标题和副标题
 * 数据来源：system_config 表（hero_title_1~4, hero_subtitle_1~4）
 */
@Data
public class HeroConfigVO {

    private List<HeroSlide> slides;

    @Data
    public static class HeroSlide {
        private String title;
        private String subtitle;
    }
}
