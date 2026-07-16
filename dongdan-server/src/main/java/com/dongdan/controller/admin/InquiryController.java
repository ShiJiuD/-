package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.constant.SubmitConstant;
import com.dongdan.dto.InquiryPageQueryDTO;
import com.dongdan.dto.InquiryStatusDTO;
import com.dongdan.dto.InquirySubmitDTO;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.service.InquiryService;
import com.dongdan.vo.InquiryPageVO;
import com.dongdan.vo.InquiryTrackVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "咨询管理_商家")
@RestController(value = "adminInquiryController")
@RequestMapping("/api/admin/inquiries")
@RequiredArgsConstructor
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    /**
     * 询价列表
     * @param dto 询价列表查询DTO
     * @return 询价列表VO
     */
    @Operation(summary = "询价列表")
    @GetMapping
    public Result<PageResult<InquiryPageVO>> list(@ParameterObject @Validated InquiryPageQueryDTO dto) {
        log.info("询价列表：status={}, page={}", dto.getStatus(), dto.getPage());
        return Result.success(inquiryService.pageAdmin(dto));
    }

    /**
     * 状态流转
     * @param id 询价ID
     * @param dto 状态流转DTO
     * @return 状态流转结果
     */
    @LogOperation(value = "询价状态流转", type = "询价")
    @Operation(summary = "状态流转")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody InquiryStatusDTO dto) {
        log.info("询价状态流转：id={}, status={}", id, dto.getStatus());
        inquiryService.updateStatus(id, dto);
        return Result.success();
    }
}
