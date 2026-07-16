package com.dongdan.mapper;

import com.dongdan.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {

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
    @Select("SELECT * FROM advantage WHERE is_visible = 1 ORDER BY sort_order ASC")
    List<AdvantageVO> listAdvantages();

    /**
     * 获取 Hero 轮播配置（标题和副标题）
     * @return HeroConfigVO
     */
    HeroConfigVO selectHeroConfig();
}
