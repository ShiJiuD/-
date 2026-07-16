package com.dongdan.service.Impl;

import com.dongdan.dto.AdvantageDTO;
import com.dongdan.dto.AdvantageStatusDTO;
import com.dongdan.entity.Advantage;
import com.dongdan.mapper.AdvantagesMapper;
import com.dongdan.service.AdvantagesService;

import com.dongdan.vo.AdvantagePageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvantagesServiceImpl implements AdvantagesService {

    private final AdvantagesMapper advantagesMapper;

    /**
     * 优势列表
     */
    @Override
    public List<AdvantagePageVO> list() {
        return advantagesMapper.list();
    }

    /**
     * 优势新增
     */
    @Override
    public void save(AdvantageDTO dto) {
        Advantage advantage = new Advantage();
        BeanUtils.copyProperties(dto, advantage);
        advantage.setIsVisible(1);
        advantagesMapper.insert(advantage);
    }

    /**
     * 优势编辑
     */
    @Override
    public void update(Long id, AdvantageDTO dto) {
        Advantage advantage = new Advantage();
        BeanUtils.copyProperties(dto, advantage);
        advantage.setId(id);
        // isVisible 从 DTO 透传，允许编辑时同时切换可见性
        if (dto.getIsVisible() == null) {
            advantage.setIsVisible(1);
        }
        advantagesMapper.update(advantage);
    }

    /**
     * 优势状态切换
     */
    @Override
    public void updateStatus(Long id, AdvantageStatusDTO dto) {
        advantagesMapper.updateStatus(id, dto.getIsVisible());
    }

    /**
     * 优势删除
     */
    @Override
    public void deleteById(Long id) {
        advantagesMapper.deleteById(id);
    }
}
