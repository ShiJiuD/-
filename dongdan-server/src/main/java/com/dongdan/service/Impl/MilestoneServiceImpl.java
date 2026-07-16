package com.dongdan.service.Impl;

import com.dongdan.dto.MilestoneDTO;
import com.dongdan.dto.MilestoneStatusDTO;
import com.dongdan.entity.Milestone;
import com.dongdan.mapper.MilestoneMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.MilestoneService;
import com.dongdan.vo.MilestonePageVO;
import com.dongdan.vo.MilestoneVO;
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
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneMapper milestoneMapper;

    @Override
    public List<MilestoneVO> listVisible() {
        log.info("查询公开历程列表");
        return milestoneMapper.listVisible();
    }

    @Override
    public PageResult<MilestonePageVO> pageAdmin(Integer page, Integer pageSize) {
        log.info("管理端分页查询历程：page={}, pageSize={}", page, pageSize);
        PageHelper.startPage(page, pageSize);
        Page<MilestonePageVO> p = (Page<MilestonePageVO>) milestoneMapper.listAdmin();
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(MilestoneDTO dto) {
        log.info("新增历程：{}", dto);
        Milestone milestone = new Milestone();
        BeanUtils.copyProperties(dto, milestone);
        milestoneMapper.insert(milestone);
    }

    @Override
    public void update(Long id, MilestoneDTO dto) {
        log.info("编辑历程：id={}, {}", id, dto);
        Milestone milestone = new Milestone();
        BeanUtils.copyProperties(dto, milestone);
        milestone.setId(id);
        milestoneMapper.update(milestone);
    }

    @Override
    public void updateStatus(Long id, MilestoneStatusDTO dto) {
        log.info("历程状态：id={}, isVisible={}", id, dto.getIsVisible());
        milestoneMapper.updateStatus(id, dto.getIsVisible());
    }

    @Override
    public void deleteById(Long id) {
        log.info("删除历程：id={}", id);
        milestoneMapper.deleteById(id);
    }
}
