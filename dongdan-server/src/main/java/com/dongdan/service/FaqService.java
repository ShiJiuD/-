package com.dongdan.service;

import com.dongdan.dto.FaqDTO;
import com.dongdan.dto.FaqPageQueryDTO;
import com.dongdan.dto.FaqStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.FaqPageVO;
import com.dongdan.vo.FaqVO;

import java.util.List;

public interface FaqService {

    /** 公开列表（仅已显示） */
    List<FaqVO> listVisible();

    /** 管理端详情 */
    FaqPageVO getById(Long id);

    /** 管理端分页列表 */
    PageResult<FaqPageVO> page(FaqPageQueryDTO dto);

    /** 新增 */
    void add(FaqDTO dto);

    /** 编辑 */
    void update(Long id, FaqDTO dto);

    /** 启用/禁用 */
    void updateStatus(Long id, FaqStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}
