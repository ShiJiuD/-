package com.dongdan.service;

import com.dongdan.dto.MilestoneDTO;
import com.dongdan.dto.MilestoneStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.MilestonePageVO;
import com.dongdan.vo.MilestoneVO;

import java.util.List;

public interface MilestoneService {

    /** 公开列表（仅可见，按 sort_order 排） */
    List<MilestoneVO> listVisible();

    /** 管理端列表（含隐藏，分页） */
    PageResult<MilestonePageVO> pageAdmin(Integer page, Integer pageSize);

    /** 新增 */
    void save(MilestoneDTO dto);

    /** 编辑 */
    void update(Long id, MilestoneDTO dto);

    /** 启用禁用 */
    void updateStatus(Long id, MilestoneStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}
