package com.dongdan.controller.user;

import com.dongdan.constant.SubmitConstant;
import com.dongdan.dto.InquirySubmitDTO;
import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.entity.Product;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.InquiryService;
import com.dongdan.service.ProductPublicService;
import com.dongdan.service.ProductService;
import com.dongdan.vo.InquiryTrackVO;
import com.dongdan.vo.ProductListVO;
import com.dongdan.vo.ProductPageVO;
import com.dongdan.vo.ProductVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "产品-用户端")
@RestController(value = "userProductController")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductPublicService productPublicService;

    @Operation(summary = "产品列表")
    @GetMapping("/api/products")
    public Result<PageResult<ProductListVO>> list(@ParameterObject @Validated ProductPageQueryDTO dto) {
        log.info("公开产品列表：categoryId={}, keyword={}, page={}", dto.getCategoryId(), dto.getKeyword(), dto.getPage());
        return Result.success(productPublicService.page(dto));
    }

    @Operation(summary = "产品详情")
    @GetMapping("/api/products/{id}")
    public Result<ProductVO> detail(@PathVariable Long id) {
        log.info("公开产品详情：id={}", id);
        return Result.success(productPublicService.detail(id));
    }
}
