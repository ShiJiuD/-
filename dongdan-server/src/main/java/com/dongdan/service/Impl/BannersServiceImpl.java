package com.dongdan.service.Impl;

import com.dongdan.dto.BannerDTO;
import com.dongdan.dto.BannerStatusDTO;
import com.dongdan.entity.Banner;
import com.dongdan.mapper.BannersMapper;
import com.dongdan.service.BannersService;
import com.dongdan.vo.BannerPageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BannersServiceImpl implements BannersService {

    private final BannersMapper bannersMapper;

    /**
     * Banner 列表
     * @return
     */
    @Override
    public List<BannerPageVO> list() {
        log.info("查询 Banner 列表");
        return bannersMapper.list();
    }

    /**
     * 新增 Banner
     * @param dto
     */
    @Override
    public void save(BannerDTO dto) {
        log.info("新增 Banner：{}", dto);
        Banner banner = new Banner();
        BeanUtils.copyProperties(dto, banner);
        banner.setIsVisible(1);   // 默认显示
        bannersMapper.insert(banner);
    }

    /**
     * 编辑 Banner
     * @param id Banner ID
     * @param dto Banner DTO
     */
    @Override
    public void update(Long id, BannerDTO dto) {
        log.info("编辑 Banner：id={}, dto={}", id, dto);
        Banner banner = new Banner();
        BeanUtils.copyProperties(dto, banner);
        banner.setId(id);
        bannersMapper.update(banner);
    }

    /**
     * 启用禁用 Banner
     * @param id Banner ID
     * @param dto Banner 状态 DTO
     */
    @Override
    public void updateStatus(Long id, BannerStatusDTO dto) {
        log.info("启用禁用 Banner id={}, dto={}", id, dto);
        bannersMapper.updateStatus(id, dto.getIsVisible());
    }

    /**
     * 删除 Banner
     * @param id Banner ID
     */
    @Override
    public void deleteById(Long id) {
        log.info("删除 Banner：id={}", id);
        bannersMapper.deleteById(id);
    }
}
