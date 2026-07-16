package com.dongdan.service;

import com.dongdan.dto.CaseDTO;
import com.dongdan.dto.CasePageQueryDTO;
import com.dongdan.dto.CaseStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.CasePageVO;

public interface CaseManageService {

    /** 管理端分页列表（含隐藏 + 搜索） */
    PageResult<CasePageVO> page(CasePageQueryDTO dto);

    /** 新增 */
    void save(CaseDTO dto);

    /** 编辑 */
    void update(Long id, CaseDTO dto);

    /** 启用禁用 */
    void updateStatus(Long id, CaseStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}