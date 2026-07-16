package com.dongdan.aspect;

import com.dongdan.entity.OperationLog;
import com.dongdan.mapper.OperationLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步写操作日志 — 独立类，确保 @Async 生效
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class LogSaveHelper {

    private final OperationLogMapper operationLogMapper;

    @Async
    public void save(OperationLog log) {
        operationLogMapper.insert(log);
    }
}
