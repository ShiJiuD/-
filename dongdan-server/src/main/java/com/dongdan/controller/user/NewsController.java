package com.dongdan.controller.user;

import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.NewsService;
import com.dongdan.vo.NewsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "新闻资讯-用户端")
@RestController(value = "userNewsController")
@RequiredArgsConstructor
@Slf4j
public class NewsController {

    private final NewsService newsService;

    /**
     * 新闻列表（公开）
     */
    @Operation(summary = "新闻列表（公开）")
    @GetMapping("/api/news")
    public Result<PageResult<NewsVO>> list(
            @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer page,
            @Parameter(description = "每页条数") @RequestParam(defaultValue = "10") Integer size) {
        log.info("新闻列表（公开）：page={}, size={}", page, size);
        return Result.success(newsService.pagePublic(page, size));
    }

    /**
     * 新闻详情（公开）
     */
    @Operation(summary = "新闻详情（公开）")
    @GetMapping("/api/news/{id}")
    public Result<NewsVO> detail(@PathVariable Long id) {
        log.info("新闻详情：id={}", id);
        return Result.success(newsService.getDetail(id));
    }
}