package com.dongdan.controller.user;

import com.dongdan.constant.SubmitConstant;
import com.dongdan.dto.InquirySubmitDTO;
import com.dongdan.result.Result;
import com.dongdan.service.InquiryService;
import com.dongdan.vo.InquiryTrackVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "咨询管理_用户")
@RestController(value = "userInquiryController")
@RequiredArgsConstructor
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    @Operation(summary = "咨询价格")
    @PostMapping("/api/inquiries")
    public Result<Map<String, String>> inquiryPrice(@RequestBody @Validated InquirySubmitDTO dto) {
        log.info("咨询价格，参数：{}", dto);
        String code = inquiryService.submit(dto);
        Map<String, String> map = new HashMap<>();
        map.put("inquiryCode", code);
        map.put("message", SubmitConstant.SUCCESS_MESSAGE);
        return Result.success(map);
    }

    @Operation(summary = "查询询价进度")
    @GetMapping("/api/inquiries/query")
    public Result<InquiryTrackVO> query(@RequestParam String code) {
        log.info("查询询价进度：code={}", code);
        return Result.success(inquiryService.trackByCode(code));
    }
}
