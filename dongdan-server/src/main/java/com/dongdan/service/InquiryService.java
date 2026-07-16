package com.dongdan.service;

import com.dongdan.dto.InquiryPageQueryDTO;
import com.dongdan.dto.InquiryStatusDTO;
import com.dongdan.dto.InquirySubmitDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.InquiryPageVO;
import com.dongdan.vo.InquiryTrackVO;

public interface InquiryService {

    /**
     * 提交咨询
     * @param dto 咨询提交DTO
     * @return 咨询编码
     */
    String submit(InquirySubmitDTO dto);

    /**
     * 查询询价进度
     * @param code 咨询编码
     * @return 咨询询价进度VO
     */
    InquiryTrackVO trackByCode(String code);

    /**
     * 询价列表
     * @param dto 询价列表查询DTO
     * @return 询价列表VO
     */
    PageResult<InquiryPageVO> pageAdmin(InquiryPageQueryDTO dto);

    /**
     * 更新询价状态
     * @param id 咨询ID
     * @param dto 咨询状态DTO
     */
    void updateStatus(Long id, InquiryStatusDTO dto);
}
