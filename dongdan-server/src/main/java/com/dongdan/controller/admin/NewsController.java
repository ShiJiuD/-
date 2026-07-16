package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.NewsDTO;
import com.dongdan.dto.NewsPageQueryDTO;
import com.dongdan.dto.NewsStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.NewsService;
import com.dongdan.vo.NewsPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "新闻资讯-管理端")
@RestController(value = "adminNewsController")
@RequestMapping("/api/admin/news")
@RequiredArgsConstructor
@Slf4j
public class NewsController {

    private final NewsService newsService;

    /**
     * 新闻列表（含隐藏）
     */
    @Operation(summary = "新闻列表（含隐藏）")
    @GetMapping
    public Result<PageResult<NewsPageVO>> list(@ParameterObject @Validated NewsPageQueryDTO dto) {
        log.info("新闻列表（管理）：keyword={}, page={}", dto.getKeyword(), dto.getPage());
        return Result.success(newsService.pageAdmin(dto));
    }

    /**
     * 新闻详情（管理端，含 content）
     */
    @Operation(summary = "新闻详情（管理端，含 content）")
    @GetMapping("/{id}")
    public Result<NewsPageVO> detail(@PathVariable Long id) {
        log.info("新闻详情（管理端）：id={}", id);
        return Result.success(newsService.getAdminDetail(id));
    }

    /**
     * 新闻新增
     */
    @LogOperation(value = "新增新闻", type = "新闻")
    @Operation(summary = "新增新闻")
    @PostMapping
    public Result save(@RequestBody @Validated NewsDTO dto) {
        log.info("新增新闻：{}", dto.getTitle());
        newsService.save(dto);
        return Result.success();
    }

    /**
     * 新闻编辑
     */
    @LogOperation(value = "编辑新闻", type = "新闻")
    @Operation(summary = "编辑新闻")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated NewsDTO dto) {
        log.info("编辑新闻：id={}", id);
        newsService.update(id, dto);
        return Result.success();
    }

    /**
     * 新闻状态切换
     */
    @LogOperation(value = "新闻发布隐藏", type = "新闻")
    @Operation(summary = "发布/隐藏")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody NewsStatusDTO dto) {
        log.info("新闻状态：id={}, isVisible={}", id, dto.getIsVisible());
        newsService.updateStatus(id, dto);
        return Result.success();
    }

    /**
     * 新闻删除
     */
    @LogOperation(value = "删除新闻", type = "新闻")
    @Operation(summary = "删除新闻")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除新闻：id={}", id);
        newsService.deleteById(id);
        return Result.success();
    }
}