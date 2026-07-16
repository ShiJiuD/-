package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.FaqDTO;
import com.dongdan.dto.FaqPageQueryDTO;
import com.dongdan.dto.FaqStatusDTO;
import com.dongdan.entity.Faq;
import com.dongdan.exception.BusinessException;
import com.dongdan.mapper.FaqMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.FaqService;
import com.dongdan.vo.FaqPageVO;
import com.dongdan.vo.FaqVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FaqServiceImpl implements FaqService {

    private final FaqMapper faqMapper;

    @Override
    public List<FaqVO> listVisible() {
        log.info("查询公开问答列表");
        return faqMapper.listVisible();
    }

    @Override
    public FaqPageVO getById(Long id) {
        FaqPageVO vo = faqMapper.selectById(id);
        if (vo == null) {
            throw new BusinessException(MessageConstant.FAQ_NOT_FOUND);
        }
        return vo;
    }

    @Override
    public PageResult<FaqPageVO> page(FaqPageQueryDTO dto) {
        log.info("管理端分页查询问答：{}", dto);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<FaqPageVO> page = (Page<FaqPageVO>) faqMapper.page(dto);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void add(FaqDTO dto) {
        log.info("新增问答：{}", dto);
        Faq faq = new Faq();
        BeanUtils.copyProperties(dto, faq);
        faqMapper.insert(faq);
    }

    @Override
    public void update(Long id, FaqDTO dto) {
        log.info("更新问答：id={}, {}", id, dto);
        Faq faq = new Faq();
        BeanUtils.copyProperties(dto, faq);
        faq.setId(id);
        faqMapper.update(faq);
    }

    @Override
    public void updateStatus(Long id, FaqStatusDTO dto) {
        log.info("更新问答状态：id={}, {}", id, dto);
        Faq faq = new Faq();
        faq.setIsVisible(dto.getIsVisible());
        faq.setId(id);
        faqMapper.update(faq);
    }

    @Override
    public void deleteById(Long id) {
        log.info("删除问答：id={}", id);
        faqMapper.deleteById(id);
    }
}
