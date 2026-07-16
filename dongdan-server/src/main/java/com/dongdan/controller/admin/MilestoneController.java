package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.MilestoneDTO;
import com.dongdan.dto.MilestoneStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.MilestoneService;
import com.dongdan.vo.MilestonePageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "发展历程-管理端")
@RestController("adminMilestoneController")
@RequestMapping("/api/admin/milestones")
@RequiredArgsConstructor
@Slf4j
public class MilestoneController {

    private final MilestoneService milestoneService;

    @Operation(summary = "历程列表（含隐藏）")
    @GetMapping
    public Result<PageResult<MilestonePageVO>> list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        log.info("历程列表（管理）：page={}, pageSize={}", page, pageSize);
        return Result.success(milestoneService.pageAdmin(page, pageSize));
    }

    @LogOperation(value = "新增历程", type = "历程")
    @Operation(summary = "新增历程")
    @PostMapping
    public Result save(@RequestBody @Validated MilestoneDTO dto) {
        log.info("新增历程：{}", dto.getYear());
        milestoneService.save(dto);
        return Result.success();
    }

    @LogOperation(value = "编辑历程", type = "历程")
    @Operation(summary = "编辑历程")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated MilestoneDTO dto) {
        log.info("编辑历程：id={}", id);
        milestoneService.update(id, dto);
        return Result.success();
    }

    @LogOperation(value = "历程启用禁用", type = "历程")
    @Operation(summary = "启用禁用")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody MilestoneStatusDTO dto) {
        log.info("历程状态：id={}, isVisible={}", id, dto.getIsVisible());
        milestoneService.updateStatus(id, dto);
        return Result.success();
    }

    @LogOperation(value = "删除历程", type = "历程")
    @Operation(summary = "删除历程")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除历程：id={}", id);
        milestoneService.deleteById(id);
        return Result.success();
    }
}
