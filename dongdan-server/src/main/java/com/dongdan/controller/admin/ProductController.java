package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.dto.BatchDeleteDTO;
import com.dongdan.dto.ProductDTO;
import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.dto.ProductStatusDTO;
import com.dongdan.entity.Product;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.AdminUserService;
import com.dongdan.service.ProductService;
import com.dongdan.vo.ProductPageVO;
import com.dongdan.vo.ProductVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "产品管理-管理员端")
@RestController(value = "adminProductController")
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "获取产品列表")
    @GetMapping
    public Result<PageResult<ProductPageVO>> getProducts(@ParameterObject @Validated ProductPageQueryDTO pageDto) {
        log.info("获取产品列表请求：{}页，{}条", pageDto.getPage(), pageDto.getPageSize());
        PageResult<ProductPageVO> result = productService.page(pageDto);
        return Result.success(result);
    }

    @Operation(summary = "获取产品详情")
    @GetMapping("/{id}")
    public Result<ProductVO> getProduct(@PathVariable Long id) {
        log.info("获取产品详情请求：{}", id);
        ProductVO product = productService.getById(id);
        return Result.success(product);
    }

    @LogOperation(value = "新增产品", type = "产品")
    @Operation(summary = "新增产品")
    @PostMapping
    public Result addProduct(@RequestBody @Validated ProductDTO productDTO) {
        log.info("新增产品请求：{}", productDTO);
        productService.add(productDTO);
        return Result.success();
    }

    @LogOperation(value = "批量删除产品", type = "产品")
    @Operation(summary = "删除产品(批量)")
    @DeleteMapping("/batch")
    public Result deleteProducts(@RequestBody @Validated BatchDeleteDTO batchDeleteDTO) {
        log.info("批量删除产品请求：{}", batchDeleteDTO);
        productService.deleteBatch(batchDeleteDTO.getIds());
        return Result.success();
    }

    @LogOperation(value = "编辑产品", type = "产品")
    @Operation(summary = "更新产品")
    @PutMapping("/{id}")
    public Result updateProduct(@PathVariable Long id, @RequestBody @Validated ProductDTO productDTO) {
        log.info("更新产品请求：{}, {}", id, productDTO);
        productService.update(id, productDTO);
        return Result.success();
    }

    @LogOperation(value = "产品上下架", type = "产品")
    @Operation(summary = "产品的上下架")
    @PutMapping("/{id}/status")
    public Result updateProductStatus(@PathVariable Long id, @RequestBody ProductStatusDTO statusDTO) {
        log.info("更新产品上下架状态：{}, {}", id, statusDTO);
        productService.updateStatus(id, statusDTO);
        return Result.success();
    }

    @LogOperation(value = "删除产品", type = "产品")
    @Operation(summary = "删除产品(单条)")
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Long id) {
        log.info("删除产品请求：{}", id);
        productService.delete(id);
        return Result.success();
    }

}

