package com.dongdan.controller.user;

import com.dongdan.result.Result;
import com.dongdan.service.MilestoneService;
import com.dongdan.vo.MilestoneVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "发展历程-用户端")
@RestController("userMilestoneController")
@RequiredArgsConstructor
@Slf4j
public class MilestoneController {

    private final MilestoneService milestoneService;

    @Operation(summary = "发展历程列表（公开）")
    @GetMapping("/api/milestones")
    public Result<List<MilestoneVO>> list() {
        log.info("发展历程列表（公开）");
        return Result.success(milestoneService.listVisible());
    }
}
