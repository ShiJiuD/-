package com.dongdan.service.Impl;

import com.dongdan.mapper.HomeMapper;
import com.dongdan.service.HomeService;
import com.dongdan.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;

    /**
     * 获取首页banner
     * @return banner列表
     */
    @Override
    public List<BannerVO> listBanners() {
        log.info("获取首页banner请求");
        return homeMapper.listBanners();
    }

    /**
     * 获取首页数据看板
     * @return 数据看板
     */
    @Override
    public HomeStatsVO getStats() {
        log.info("获取首页数据看板请求");
        return homeMapper.getStats();
    }

    /**
     * 获取分类列表
     * @return 分类列表
     */
    @Override
    public List<CategoryVO> listVisibleCategories() {
        log.info("获取可见分类列表请求");
        return homeMapper.listVisibleCategories();
    }

    /**
     * 获取精选产品列表
     * @param limit 限制数量
     * @return 精选产品列表
     */
    @Override
    public List<FeaturedProductVO> listFeaturedProducts(Integer limit) {
        return homeMapper.listFeaturedProducts(limit);
    }

    /**
     * 获取优势列表
     * @return 优势列表
     */
    @Override
    public List<AdvantageVO> listAdvantages() {
        log.info("获取优势列表请求");
        return homeMapper.listAdvantages();
    }

    @Override
    public HeroConfigVO getHeroConfig() {
        log.info("获取 Hero 轮播配置请求");
        return homeMapper.selectHeroConfig();
    }
}
