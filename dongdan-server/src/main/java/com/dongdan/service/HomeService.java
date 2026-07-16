package com.dongdan.service;

import com.dongdan.vo.*;

import java.util.List;

public interface HomeService {

    /**
     * 获取首页banner
     * @return banner列表
     */
    List<BannerVO> listBanners();

    /**
     * 获取首页数据看板
     * @return 数据看板
     */
    HomeStatsVO getStats();

    /**
     * 获取分类列表
     * @return 分类列表
     */
    List<CategoryVO> listVisibleCategories();

    /**
     * 获取精选产品列表
     * @param limit 限制数量
     * @return 精选产品列表
     */
    List<FeaturedProductVO> listFeaturedProducts(Integer limit);

    /**
     * 获取优势列表
     * @return 优势列表
     */
    List<AdvantageVO> listAdvantages();

    /**
     * 获取 Hero 轮播配置
     * @return HeroConfigVO
     */
    HeroConfigVO getHeroConfig();
}
