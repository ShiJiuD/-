package com.dongdan.service.Impl;

import com.dongdan.entity.SystemConfig;
import com.dongdan.mapper.SettingsMapper;
import com.dongdan.service.SettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SettingsServiceImpl implements SettingsService {

    private final SettingsMapper settingMapper;

    /** 读取所有系统配置 */
    @Override
    public Map<String, String> getAll() {
        log.info("读取系统配置");
        List<SystemConfig> list = settingMapper.selectAll();
        Map<String, String> map = new LinkedHashMap<>();
        for (SystemConfig config : list) {
            // config_key 是 snake_case（如 daily_capacity），前端期望 camelCase（如 dailyCapacity）
            String camelKey = snakeToCamel(config.getConfigKey());
            map.put(camelKey, config.getConfigValue());
        }
        return map;
    }

    /** daily_capacity → dailyCapacity */
    private String snakeToCamel(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean upper = false;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                upper = true;
                continue;
            }
            sb.append(upper ? Character.toUpperCase(c) : c);
            upper = false;
        }
        return sb.toString();
    }

    /** 批量更新系统配置 */
    @Override
    public void batchUpdate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // 前端传的是 camelCase，存回 DB 需转 snake_case
            String dbKey = camelToSnake(entry.getKey());
            settingMapper.upsert(dbKey, entry.getValue());
        }
    }

    /** dailyCapacity → daily_capacity */
    private String camelToSnake(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append('_').append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}