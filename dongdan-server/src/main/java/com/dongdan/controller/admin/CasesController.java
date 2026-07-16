package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.CaseDTO;
import com.dongdan.dto.CasePageQueryDTO;
import com.dongdan.dto.CaseStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.CaseManageService;
import com.dongdan.vo.CasePageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "客户案例管理")
@RestController(value = "adminCaseController")
@RequestMapping("/api/admin/cases")
@RequiredArgsConstructor
@Slf4j
public class CasesController {

    private final CaseManageService caseManageService;

    @Operation(summary = "案例列表（含隐藏）")
    @GetMapping
    public Result<PageResult<CasePageVO>> list(@ParameterObject @Validated CasePageQueryDTO dto) {
        log.info("案例列表（管理）：keyword={}, page={}", dto.getKeyword(), dto.getPage());
        return Result.success(caseManageService.page(dto));
    }

    @LogOperation(value = "新增案例", type = "案例")
    @Operation(summary = "新增案例")
    @PostMapping
    public Result save(@RequestBody @Validated CaseDTO dto) {
        log.info("新增案例：{}", dto.getClientName());
        caseManageService.save(dto);
        return Result.success();
    }

    @LogOperation(value = "编辑案例", type = "案例")
    @Operation(summary = "编辑案例")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated CaseDTO dto) {
        log.info("编辑案例：id={}", id);
        caseManageService.update(id, dto);
        return Result.success();
    }

    @LogOperation(value = "案例启用禁用", type = "案例")
    @Operation(summary = "启用禁用")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody CaseStatusDTO dto) {
        log.info("案例状态：id={}, isVisible={}", id, dto.getIsVisible());
        caseManageService.updateStatus(id, dto);
        return Result.success();
    }

    @LogOperation(value = "删除案例", type = "案例")
    @Operation(summary = "删除案例")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除案例：id={}", id);
        caseManageService.deleteById(id);
        return Result.success();
    }
}