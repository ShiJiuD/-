package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.CaseDTO;
import com.dongdan.dto.CasePageQueryDTO;
import com.dongdan.dto.CaseStatusDTO;
import com.dongdan.entity.CustomerCase;
import com.dongdan.exception.ResourceNotFoundException;
import com.dongdan.mapper.CaseManageMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.CaseManageService;
import com.dongdan.vo.CasePageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaseManageServiceImpl implements CaseManageService {

    private final CaseManageMapper caseManageMapper;

    @Override
    public PageResult<CasePageVO> page(CasePageQueryDTO dto) {
        log.info("管理端分页查询案例：{}", dto);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<CasePageVO> p = (Page<CasePageVO>) caseManageMapper.page(dto);
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(CaseDTO dto) {
        log.info("新增案例：{}", dto);
        CustomerCase c = new CustomerCase();
        BeanUtils.copyProperties(dto, c);
        caseManageMapper.insert(c);
    }

    @Override
    public void update(Long id, CaseDTO dto) {
        log.info("编辑案例：id={}, {}", id, dto);
        CustomerCase c = new CustomerCase();
        BeanUtils.copyProperties(dto, c);
        c.setId(id);
        int rows = caseManageMapper.update(c);
        if (rows == 0) {
            throw new ResourceNotFoundException(MessageConstant.CASE_NOT_FOUND);
        }
    }

    @Override
    public void updateStatus(Long id, CaseStatusDTO dto) {
        log.info("案例状态：id={}, isVisible={}", id, dto.getIsVisible());
        int rows = caseManageMapper.updateStatus(id, dto.getIsVisible());
        if (rows == 0) {
            throw new ResourceNotFoundException(MessageConstant.CASE_NOT_FOUND);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("删除案例：id={}", id);
        int rows = caseManageMapper.deleteById(id);
        if (rows == 0) {
            throw new ResourceNotFoundException(MessageConstant.CASE_NOT_FOUND);
        }
    }
}