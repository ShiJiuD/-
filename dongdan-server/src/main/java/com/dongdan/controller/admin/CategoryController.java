package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.CategoryDTO;
import com.dongdan.dto.CategoryPageQueryDTO;
import com.dongdan.dto.CategoryStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.CategoryService;
import com.dongdan.vo.CategoryPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类管理")
@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "获取分类列表")
    @GetMapping
    public Result<PageResult<CategoryPageVO>> list(@ParameterObject @Validated CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("获取分类列表请求：{}", categoryPageQueryDTO);
        PageResult<CategoryPageVO> pageResult = categoryService.page(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @LogOperation(value = "新增分类", type = "分类")
    @Operation(summary = "增加分类")
    @PostMapping
    public Result add(@RequestBody @Validated CategoryDTO categoryDTO) {
        log.info("增加分类请求：{}", categoryDTO);
        categoryService.add(categoryDTO);
        return Result.success();
    }

    @LogOperation(value = "编辑分类", type = "分类")
    @Operation(summary = "更新分类")
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody @Validated CategoryDTO categoryDTO) {
        log.info("更新分类请求：{}", categoryDTO);
        categoryService.update(id, categoryDTO);
        return Result.success();
    }

    @LogOperation(value = "分类启用禁用", type = "分类")
    @Operation(summary = "启用禁用分类")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody @Validated CategoryStatusDTO categoryStatusDTO) {
        log.info("更新分类状态请求：{}, {}", id, categoryStatusDTO);
        categoryService.updateStatus(id, categoryStatusDTO);
        return Result.success();
    }

    @LogOperation(value = "删除分类", type = "分类")
    @Operation(summary = "删除分类")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除分类请求：{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }
}

