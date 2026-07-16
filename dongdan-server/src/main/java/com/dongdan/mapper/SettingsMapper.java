package com.dongdan.mapper;

import com.dongdan.entity.SystemConfig;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SettingsMapper {

    /** 全量读取，按 sort_order 排序 */
    @Select("SELECT * FROM system_config ORDER BY sort_order ASC")
    List<SystemConfig> selectAll();

    /**
     * 逐条 upsert
     * config_key 有唯一约束 → 存在则更新 config_value，不存在则插入
     */
    @Update("INSERT INTO system_config (config_key, config_value) VALUES (#{key}, #{value}) " +
            "ON DUPLICATE KEY UPDATE config_value = VALUES(config_value)")
    void upsert(@Param("key") String key, @Param("value") String value);
}
