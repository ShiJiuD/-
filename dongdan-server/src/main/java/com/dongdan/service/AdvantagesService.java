package com.dongdan.service;

import com.dongdan.dto.AdvantageDTO;
import com.dongdan.dto.AdvantageStatusDTO;
import com.dongdan.vo.AdvantagePageVO;

import java.util.List;

public interface AdvantagesService {

    /** 全量列表（管理端，含隐藏） */
    List<AdvantagePageVO> list();

    /** 新增 */
    void save(AdvantageDTO dto);

    /** 编辑 */
    void update(Long id, AdvantageDTO dto);

    /** 启用禁用 */
    void updateStatus(Long id, AdvantageStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}
