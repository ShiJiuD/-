package com.dongdan.controller.admin;

import com.dongdan.dto.LoginDTO;
import com.dongdan.result.Result;
import com.dongdan.service.AdminUserService;
import com.dongdan.service.DashboardService;
import com.dongdan.vo.DashboardVO;
import com.dongdan.vo.InquiryPageVO;
import com.dongdan.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "管理工作台")
@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final DashboardService dashboardService;

    /** 工作台统计数据 */
    @Operation(summary = "工作台统计")
    @GetMapping("/stats")
    public Result<DashboardVO> stats() {
        log.info("工作台统计");
        return Result.success(dashboardService.getStats());
    }

    /** 最近询价 */
    @Operation(summary = "最近询价")
    @GetMapping("/recent-inquiries")
    public Result<List<InquiryPageVO>> recentInquiries(
            @RequestParam(defaultValue = "5") Integer limit) {
        log.info("最近询价：limit={}", limit);
        return Result.success(dashboardService.listRecentInquiries(limit));
    }
}
