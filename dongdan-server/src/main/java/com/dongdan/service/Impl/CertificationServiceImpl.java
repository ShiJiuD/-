package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.CertificationDTO;
import com.dongdan.dto.CertificationPageQueryDTO;
import com.dongdan.dto.CertificationStatusDTO;
import com.dongdan.entity.Certification;
import com.dongdan.exception.BusinessException;
import com.dongdan.mapper.CertificationMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.CertificationService;
import com.dongdan.vo.CertificationPageVO;
import com.dongdan.vo.CertificationVO;
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
public class CertificationServiceImpl implements CertificationService {

    private final CertificationMapper certificationMapper;

    @Override
    public List<CertificationVO> listVisible() {
        log.info("查询公开认证列表");
        return certificationMapper.listVisible();
    }

    @Override
    public CertificationPageVO getById(Long id) {
        CertificationPageVO vo = certificationMapper.selectById(id);
        if (vo == null) {
            throw new BusinessException(MessageConstant.CERT_NOT_FOUND);
        }
        return vo;
    }

    @Override
    public PageResult<CertificationPageVO> page(CertificationPageQueryDTO dto) {
        log.info("管理端分页查询认证：{}", dto);
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<CertificationPageVO> page = (Page<CertificationPageVO>) certificationMapper.page(dto);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void add(CertificationDTO dto) {
        log.info("新增认证：{}", dto);
        Certification cert = new Certification();
        BeanUtils.copyProperties(dto, cert);
        certificationMapper.insert(cert);
    }

    @Override
    public void update(Long id, CertificationDTO dto) {
        log.info("更新认证：id={}, {}", id, dto);
        Certification cert = new Certification();
        BeanUtils.copyProperties(dto, cert);
        cert.setId(id);
        certificationMapper.update(cert);
    }

    @Override
    public void updateStatus(Long id, CertificationStatusDTO dto) {
        log.info("更新认证状态：id={}, {}", id, dto);
        Certification cert = new Certification();
        cert.setIsVisible(dto.getIsVisible());
        cert.setId(id);
        certificationMapper.update(cert);
    }

    @Override
    public void deleteById(Long id) {
        log.info("删除认证：id={}", id);
        certificationMapper.deleteById(id);
    }
}
