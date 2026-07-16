package com.dongdan.service;

import com.dongdan.dto.ProductDTO;
import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.dto.ProductStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.ProductPageVO;
import com.dongdan.vo.ProductVO;

import java.util.List;

public interface ProductService {
    /**
     * 分页查询产品列表
     *
     * @param pageDto 分页查询参数
     * @return 页结果
     */
    PageResult<ProductPageVO> page(ProductPageQueryDTO pageDto);

    /**
     * 根据产品ID查询产品详情
     * @param id 产品ID
     * @return 产品详情
     */
    ProductVO getById(Long id);

    /**
     * 新增产品
     * @param productDTO 产品DTO
     * @return 新增的产品VO
     */
    void add(ProductDTO productDTO);

    /**
     * 更新产品
     * @param id 产品ID
     * @param productDTO 产品DTO
     */
    void update(Long id, ProductDTO productDTO);

    /**
     * 删除产品(单条)
     * @param id 产品ID
     */
    void delete(Long id);

    /**
     * 删除产品(批量)
     * @param ids 产品ID列表
     */
    void deleteBatch(List<Long> ids);

    /**
     * 更新产品上下架状态
     * @param id 产品ID
     * @param statusDTO 产品状态DTO
     */
    void updateStatus(Long id, ProductStatusDTO statusDTO);

}
