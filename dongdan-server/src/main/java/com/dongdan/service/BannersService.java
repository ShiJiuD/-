package com.dongdan.service;

import com.dongdan.dto.BannerDTO;
import com.dongdan.dto.BannerStatusDTO;
import com.dongdan.vo.BannerPageVO;

import java.util.List;

public interface BannersService {

    /**
     * Banner 列表
     * @return Banner 列表VO
     */
    List<BannerPageVO> list();

    /**
     * 新增 Banner
     * @param dto Banner DTO
     */
    void save(BannerDTO dto);

    /**
     * 编辑 Banner
     * @param id Banner ID
     * @param dto Banner DTO
     */
    void update(Long id, BannerDTO dto);

    /**
     * 启用禁用 Banner
     * @param id Banner ID
     * @param dto Banner 状态 DTO
     */
    void updateStatus(Long id, BannerStatusDTO dto);

    /**
     * 删除 Banner
     * @param id Banner ID
     */
    void deleteById(Long id);
}
