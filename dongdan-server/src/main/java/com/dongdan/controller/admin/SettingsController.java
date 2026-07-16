package com.dongdan.controller.admin;

import com.dongdan.annotation.LogOperation;
import com.dongdan.result.Result;
import com.dongdan.service.SettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "系统设置")
@RestController
@RequestMapping("/api/admin/settings")
@RequiredArgsConstructor
@Slf4j
public class SettingsController {

    private final SettingsService settingsService;

    /**
     * 获取配置
     * @return 配置
     */
    @Operation(summary = "获取配置")
    @GetMapping
    public Result<Map<String, String>> getSettings() {
        log.info("获取系统配置");
        return Result.success(settingsService.getAll());
    }

    /**
     * 批量更新配置
     * @param map 配置
     * @return 结果
     */
    @LogOperation(value = "更新系统配置", type = "配置")
    @Operation(summary = "批量更新配置")
    @PutMapping
    public Result updateSettings(@RequestBody Map<String, String> map) {
        log.info("批量更新系统配置：{}", map.keySet());
        settingsService.batchUpdate(map);
        return Result.success();
    }
}
