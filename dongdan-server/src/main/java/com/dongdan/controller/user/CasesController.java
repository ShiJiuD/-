package com.dongdan.controller.user;

import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.CasesService;
import com.dongdan.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "案例")
@RestController(value = "userCasesController")
@RequestMapping("/api/cases")
@Slf4j
@RequiredArgsConstructor
@Validated
public class CasesController {

    private final CasesService casesService;

    @Operation(summary = "案例列表")
    @GetMapping
    public Result<PageResult<CaseVO>> list(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "页码最小为1") Integer page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "每页数量最小为1") @Max(value = 100, message = "每页数量最大为100") Integer size) {
        log.info("案例列表：page={}, size={}", page, size);
        return Result.success(casesService.page(page, size));
    }

}
