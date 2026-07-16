package com.dongdan.service;

import com.dongdan.dto.CertificationDTO;
import com.dongdan.dto.CertificationPageQueryDTO;
import com.dongdan.dto.CertificationStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.CertificationPageVO;
import com.dongdan.vo.CertificationVO;

import java.util.List;

public interface CertificationService {

    /** 公开列表（仅已显示） */
    List<CertificationVO> listVisible();

    /** 管理端详情 */
    CertificationPageVO getById(Long id);

    /** 管理端分页列表 */
    PageResult<CertificationPageVO> page(CertificationPageQueryDTO dto);

    /** 新增 */
    void add(CertificationDTO dto);

    /** 编辑 */
    void update(Long id, CertificationDTO dto);

    /** 启用/禁用 */
    void updateStatus(Long id, CertificationStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}
