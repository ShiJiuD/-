package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.CertificationDTO;
import com.dongdan.dto.CertificationPageQueryDTO;
import com.dongdan.dto.CertificationStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.CertificationService;
import com.dongdan.vo.CertificationPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "荣誉认证管理")
@RestController
@RequestMapping("/api/admin/certifications")
@RequiredArgsConstructor
@Slf4j
public class CertificationController {

    private final CertificationService certificationService;

    @Operation(summary = "获取认证列表")
    @GetMapping
    public Result<PageResult<CertificationPageVO>> list(@ParameterObject @Validated CertificationPageQueryDTO dto) {
        log.info("获取认证列表请求：{}", dto);
        return Result.success(certificationService.page(dto));
    }

    @Operation(summary = "获取认证详情")
    @GetMapping("/{id}")
    public Result<CertificationPageVO> detail(@PathVariable Long id) {
        log.info("获取认证详情请求：id={}", id);
        return Result.success(certificationService.getById(id));
    }

    @LogOperation(value = "新增认证", type = "认证")
    @Operation(summary = "增加认证")
    @PostMapping
    public Result add(@RequestBody @Validated CertificationDTO dto) {
        log.info("增加认证请求：{}", dto);
        certificationService.add(dto);
        return Result.success();
    }

    @LogOperation(value = "编辑认证", type = "认证")
    @Operation(summary = "更新认证")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated CertificationDTO dto) {
        log.info("更新认证请求：id={}, {}", id, dto);
        certificationService.update(id, dto);
        return Result.success();
    }

    @LogOperation(value = "认证启用禁用", type = "认证")
    @Operation(summary = "启用禁用认证")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody @Validated CertificationStatusDTO dto) {
        log.info("更新认证状态请求：id={}, {}", id, dto);
        certificationService.updateStatus(id, dto);
        return Result.success();
    }

    @LogOperation(value = "删除认证", type = "认证")
    @Operation(summary = "删除认证")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除认证请求：id={}", id);
        certificationService.deleteById(id);
        return Result.success();
    }
}
