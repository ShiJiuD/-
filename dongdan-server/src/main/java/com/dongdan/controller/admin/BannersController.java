package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.BannerDTO;
import com.dongdan.dto.BannerStatusDTO;
import com.dongdan.result.Result;
import com.dongdan.service.BannersService;
import com.dongdan.vo.BannerPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Banner接口")
@RestController
@RequestMapping("/api/admin/banners")
@RequiredArgsConstructor
@Slf4j
public class BannersController {

    private final BannersService bannersService;

    /**
     * Banner 列表
     * @return Banner 列表
     */
    @Operation(summary = "Banner 列表")
    @GetMapping
    public Result<List<BannerPageVO>> list() {
        log.info("Banner 列表");
        return Result.success(bannersService.list());
    }

    /**
     * 新增 Banner
     * @param dto Banner DTO
     * @return
     */
    @LogOperation(value = "新增Banner", type = "Banner")
    @Operation(summary = "新增 Banner")
    @PostMapping
    public Result save(@RequestBody @Validated BannerDTO dto) {
        log.info("新增 Banner：{}", dto.getTitle());
        bannersService.save(dto);
        return Result.success();
    }

    /**
     * 编辑 Banner
     * @param id Banner ID
     * @param dto Banner DTO
     * @return
     */
    @LogOperation(value = "编辑Banner", type = "Banner")
    @Operation(summary = "编辑 Banner")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated BannerDTO dto) {
        log.info("编辑 Banner：id={}", id);
        bannersService.update(id, dto);
        return Result.success();
    }

    /**
     * 启用禁用 Banner
     * @param id Banner ID
     * @param dto Banner 状态 DTO
     * @return
     */
    @LogOperation(value = "Banner启用禁用", type = "Banner")
    @Operation(summary = "启用禁用")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody BannerStatusDTO dto) {
        log.info("Banner 状态：id={}, isVisible={}", id, dto.getIsVisible());
        bannersService.updateStatus(id, dto);
        return Result.success();
    }

    /**
     * 删除 Banner
     * @param id Banner ID
     * @return
     */
    @LogOperation(value = "删除Banner", type = "Banner")
    @Operation(summary = "删除 Banner")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除 Banner：id={}", id);
        bannersService.deleteById(id);
        return Result.success();
    }
}
