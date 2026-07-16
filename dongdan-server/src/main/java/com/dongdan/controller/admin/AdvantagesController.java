package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.AdvantageDTO;
import com.dongdan.dto.AdvantageStatusDTO;
import com.dongdan.result.Result;
import com.dongdan.service.AdvantagesService;
import com.dongdan.vo.AdvantagePageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商家优势接口")
@RestController
@RequestMapping("/api/admin/advantages")
@RequiredArgsConstructor
@Slf4j
public class AdvantagesController {

    private final AdvantagesService advantagesService;

    /**
     * 优势列表
     */
    @Operation(summary = "优势列表")
    @GetMapping
    public Result<List<AdvantagePageVO>> list() {
        log.info("优势列表");
        return Result.success(advantagesService.list());
    }

    /**
     * 新增优势
     */
    @LogOperation(value = "新增优势", type = "优势")
    @Operation(summary = "新增优势")
    @PostMapping
    public Result save(@RequestBody @Validated AdvantageDTO dto) {
        log.info("新增优势：{}", dto.getTitle());
        advantagesService.save(dto);
        return Result.success();
    }

    /**
     * 编辑优势
     */
    @LogOperation(value = "编辑优势", type = "优势")
    @Operation(summary = "编辑优势")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated AdvantageDTO dto) {
        log.info("编辑优势：id={}", id);
        advantagesService.update(id, dto);
        return Result.success();
    }

    /**
     * 启用禁用优势
     */
    @LogOperation(value = "优势启用禁用", type = "优势")
    @Operation(summary = "启用禁用")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody AdvantageStatusDTO dto) {
        log.info("优势状态：id={}, isVisible={}", id, dto.getIsVisible());
        advantagesService.updateStatus(id, dto);
        return Result.success();
    }

    /**
     * 删除优势
     */
    @LogOperation(value = "删除优势", type = "优势")
    @Operation(summary = "删除优势")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除优势：id={}", id);
        advantagesService.deleteById(id);
        return Result.success();
    }
}
