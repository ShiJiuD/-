package com.dongdan.controller.user;

import com.dongdan.result.Result;
import com.dongdan.service.CertificationService;
import com.dongdan.service.FaqService;
import com.dongdan.service.HomeService;
import com.dongdan.service.SettingsService;
import com.dongdan.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "首页")
@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final FaqService faqService;
    private final CertificationService certificationService;
    private final SettingsService settingsService;

    @Operation(summary = "获取首页数据")
    @GetMapping("/api/home/banners")
    public Result<List<BannerVO>> banners() {
        log.info("获取首页banner请求");
        return Result.success(homeService.listBanners());
    }

    @Operation(summary = "数据看板")
    @GetMapping("/api/home/stats")
    public Result<HomeStatsVO> stats() {
        log.info("获取数据看板请求");
        return Result.success(homeService.getStats());
    }

    @Operation(summary = "分类列表")
    @GetMapping("/api/home/categories")
    public Result<List<CategoryVO>> categories() {
        log.info("获取可见分类列表请求");
        return Result.success(homeService.listVisibleCategories());
    }

    @Operation(summary = "精选产品列表")
    @GetMapping("/api/home/products/featured")
    public Result<List<FeaturedProductVO>> featuredProducts(@RequestParam(defaultValue = "8") Integer limit) {
        log.info("获取精选产品列表请求，limit={}", limit);
        return Result.success(homeService.listFeaturedProducts(limit));
    }

    @Operation(summary = "优势列表")
    @GetMapping("/api/home/advantages")
    public Result<List<AdvantageVO>> advantages() {
        log.info("获取优势列表请求");
        return Result.success(homeService.listAdvantages());
    }

    @Operation(summary = "公开分类")
    @GetMapping("/api/categories")
    public Result<List<CategoryVO>> allCategories() {
        log.info("获取公开分类列表请求");
        return Result.success(homeService.listVisibleCategories());
    }

    @Operation(summary = "Hero轮播配置")
    @GetMapping("/api/home/hero-config")
    public Result<HeroConfigVO> heroConfig() {
        log.info("获取 Hero 轮播配置请求");
        return Result.success(homeService.getHeroConfig());
    }

    @Operation(summary = "常见问答列表")
    @GetMapping("/api/faqs")
    public Result<List<FaqVO>> faqs() {
        log.info("获取常见问答列表请求");
        return Result.success(faqService.listVisible());
    }

    @Operation(summary = "荣誉认证列表")
    @GetMapping("/api/certifications")
    public Result<List<CertificationVO>> certifications() {
        log.info("获取荣誉认证列表请求");
        return Result.success(certificationService.listVisible());
    }

    @Operation(summary = "获取关于页故事配置")
    @GetMapping("/api/settings/story")
    public Result<StorySettingsVO> storySettings() {
        log.info("获取关于页故事配置");
        Map<String, String> settings = settingsService.getAll();
        StorySettingsVO vo = new StorySettingsVO();
        vo.setStoryImage(settings.getOrDefault("storyImage", ""));
        vo.setStoryDesc1(settings.getOrDefault("storyDesc1", ""));
        vo.setStoryDesc2(settings.getOrDefault("storyDesc2", ""));
        vo.setStorySubtitle(settings.getOrDefault("storySubtitle", ""));
        return Result.success(vo);
    }

    @Operation(summary = "获取联系信息")
    @GetMapping("/api/home/contact-info")
    public Result<Map<String, String>> contactInfo() {
        log.info("获取联系信息");
        Map<String, String> settings = settingsService.getAll();
        Map<String, String> result = new HashMap<>();
        result.put("phone", settings.getOrDefault("phone", ""));
        result.put("email", settings.getOrDefault("email", ""));
        result.put("address", settings.getOrDefault("address", ""));
        result.put("workHours", settings.getOrDefault("workHours", ""));
        result.put("wechatQrImage", settings.getOrDefault("wechatQrImage", ""));
        result.put("icp", settings.getOrDefault("icp", ""));
        result.put("copyright", settings.getOrDefault("copyright", ""));
        return Result.success(result);
    }
}
