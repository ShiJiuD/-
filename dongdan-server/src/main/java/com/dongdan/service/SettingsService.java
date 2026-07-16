package com.dongdan.service;

import java.util.Map;

public interface SettingsService {


    /** 获取全部配置（key → value） */
    Map<String, String> getAll();

    /** 批量更新：只传要改的 key，未传的不动 */
    void batchUpdate(Map<String, String> map);
}
