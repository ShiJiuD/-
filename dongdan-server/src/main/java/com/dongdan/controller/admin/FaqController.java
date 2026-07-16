package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.FaqDTO;
import com.dongdan.dto.FaqPageQueryDTO;
import com.dongdan.dto.FaqStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.FaqService;
import com.dongdan.vo.FaqPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "常见问答管理")
@RestController
@RequestMapping("/api/admin/faqs")
@RequiredArgsConstructor
@Slf4j
public class FaqController {

    private final FaqService faqService;

    @Operation(summary = "获取问答列表")
    @GetMapping
    public Result<PageResult<FaqPageVO>> list(@ParameterObject @Validated FaqPageQueryDTO dto) {
        log.info("获取问答列表请求：{}", dto);
        PageResult<FaqPageVO> pageResult = faqService.page(dto);
        return Result.success(pageResult);
    }

    @Operation(summary = "获取问答详情")
    @GetMapping("/{id}")
    public Result<FaqPageVO> detail(@PathVariable Long id) {
        log.info("获取问答详情请求：id={}", id);
        return Result.success(faqService.getById(id));
    }

    @LogOperation(value = "新增问答", type = "FAQ")
    @Operation(summary = "增加问答")
    @PostMapping
    public Result add(@RequestBody @Validated FaqDTO dto) {
        log.info("增加问答请求：{}", dto);
        faqService.add(dto);
        return Result.success();
    }

    @LogOperation(value = "编辑问答", type = "FAQ")
    @Operation(summary = "更新问答")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated FaqDTO dto) {
        log.info("更新问答请求：id={}, {}", id, dto);
        faqService.update(id, dto);
        return Result.success();
    }

    @LogOperation(value = "问答启用禁用", type = "FAQ")
    @Operation(summary = "启用禁用问答")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody @Validated FaqStatusDTO dto) {
        log.info("更新问答状态请求：id={}, {}", id, dto);
        faqService.updateStatus(id, dto);
        return Result.success();
    }

    @LogOperation(value = "删除问答", type = "FAQ")
    @Operation(summary = "删除问答")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除问答请求：id={}", id);
        faqService.deleteById(id);
        return Result.success();
    }
}
