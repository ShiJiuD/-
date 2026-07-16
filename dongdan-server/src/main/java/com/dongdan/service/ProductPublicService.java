package com.dongdan.service;

import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.ProductListVO;
import com.dongdan.vo.ProductVO;

public interface ProductPublicService {

    /**
     * 分页查询产品列表
     * @param dto 分页查询参数
     * @return 分页查询结果
     */
    PageResult<ProductListVO> page(ProductPageQueryDTO dto);

    /**
     * 查询产品详情
     * @param id 产品ID
     * @return 产品详情VO
     */
    ProductVO detail(Long id);
}
