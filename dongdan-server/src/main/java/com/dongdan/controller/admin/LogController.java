package com.dongdan.controller.admin;

import com.dongdan.dto.LogPageQueryDTO;
import com.dongdan.mapper.OperationLogMapper;
import com.dongdan.result.PageResult;
import com.dongdan.result.Result;
import com.dongdan.vo.LogPageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "操作日志")
@RestController
@RequestMapping("/api/admin/logs")
@RequiredArgsConstructor
@Slf4j
public class LogController {

    private final OperationLogMapper operationLogMapper;

    @Operation(summary = "日志列表（分页 + 筛选）")
    @GetMapping
    public Result<PageResult<LogPageVO>> list(@ParameterObject @Validated LogPageQueryDTO dto) {
        log.info("日志查询：keyword={}, adminName={}, type={}, page={}",
                dto.getKeyword(), dto.getAdminName(), dto.getType(), dto.getPage());
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<LogPageVO> list = operationLogMapper.page(
                dto.getKeyword(), dto.getAdminName(), dto.getType());
        Page<LogPageVO> page = (Page<LogPageVO>) list;
        return Result.success(new PageResult<>(page.getTotal(), list));
    }
}
