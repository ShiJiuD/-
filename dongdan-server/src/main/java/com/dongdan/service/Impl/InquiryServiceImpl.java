package com.dongdan.service.Impl;

import com.dongdan.constant.SubmitConstant;
import com.dongdan.dto.InquiryPageQueryDTO;
import com.dongdan.dto.InquiryStatusDTO;
import com.dongdan.dto.InquirySubmitDTO;
import com.dongdan.entity.Inquiry;
import com.dongdan.exception.BusinessException;
import com.dongdan.mapper.InquiryMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.InquiryService;
import com.dongdan.vo.InquiryPageVO;
import com.dongdan.vo.InquiryTrackVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InquiryServiceImpl implements InquiryService {

    private final InquiryMapper inquiryMapper;

    /**
     * 提交咨询
     * @param dto 咨询提交DTO
     * @return 咨询编码
     */
    @Override
    public String submit(InquirySubmitDTO dto) {
        log.info("提交咨询dto={}", dto);
        // ① 手机号校验
        if (dto.getPhone() == null || !dto.getPhone().matches("^1[3-9]\\d{9}$")) {
            throw new BusinessException(SubmitConstant.PHONE_ERROR);
        }
        // ② 生成询价编码
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String prefix = "RFQ-" + today + "-";
        String maxCode = inquiryMapper.selectMaxCodeByDate(today);
        int seq = 1;
        if (maxCode != null && maxCode.startsWith(prefix)) {
            seq = Integer.parseInt(maxCode.substring(maxCode.lastIndexOf("-") + 1)) + 1;
        }
        String code = prefix + String.format("%03d", seq);
        // ③ 插入数据库
        Inquiry inquiry = new Inquiry();
        BeanUtils.copyProperties(dto, inquiry);
        inquiry.setInquiryCode(code);
        inquiry.setStatus(0);  // 待处理
        inquiryMapper.insert(inquiry);

        return code;
    }

    /**
     * 查询询价进度
     * @param code 咨询编码
     * @return 咨询询价进度VO
     */
    @Override
    public InquiryTrackVO trackByCode(String code) {
        log.info("查询询价进度code={}", code);
        // ① 查询数据库
        Inquiry inquiry = inquiryMapper.selectByInquiryCode(code);
        if (inquiry == null) {
            throw new BusinessException(SubmitConstant.INQUIRY_NOT_FOUND);
        }
        // ② 转换为VO
        InquiryTrackVO trackVO = new InquiryTrackVO();
        BeanUtils.copyProperties(inquiry, trackVO);
        trackVO.setStatus(getStatusText(inquiry.getStatus()));
        trackVO.setStatusCode(inquiry.getStatus());
        return trackVO;
    }

    /**
     * 分页查询咨询
     * @param dto 咨询分页查询DTO
     * @return 咨询分页结果
     */
    @Override
    public PageResult<InquiryPageVO> pageAdmin(InquiryPageQueryDTO dto) {
        log.info("管理端询价分页查询：status={}, page={}", dto.getStatus(), dto.getPage());
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<InquiryPageVO> list = inquiryMapper.pageAdmin(dto.getStatus());
        // 填充中文状态
        for (InquiryPageVO vo : list) {
            vo.setStatusText(getStatusText(vo.getStatus()));
        }
        Page<InquiryPageVO> page = (Page<InquiryPageVO>) list;
        return new PageResult<>(page.getTotal(), list);
    }

    /**
     * 更新询价状态
     * @param id 咨询ID
     * @param dto 咨询状态DTO
     */
    @Override
    public void updateStatus(Long id, InquiryStatusDTO dto) {
        log.info("更新询价状态：id={}, status={}", id, dto.getStatus());
        inquiryMapper.updateStatus(id, dto.getStatus());
    }

    /**
     * 获取中文状态文本
     * @param status 状态码
     * @return 中文状态文本
     */
    private String getStatusText(Integer status) {
        switch (status) {
            case 0: return "待处理";
            case 1: return "已回复";
            case 2: return "已成交";
            case 3: return "已关闭";
            default: return "未知";
        }
    }
}
