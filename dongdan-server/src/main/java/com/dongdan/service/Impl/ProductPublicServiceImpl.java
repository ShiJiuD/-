package com.dongdan.service.Impl;

import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.mapper.ProductMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.ProductPublicService;
import com.dongdan.vo.ProductListVO;
import com.dongdan.vo.ProductVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPublicServiceImpl implements ProductPublicService {

    private final ProductMapper productMapper;

    /**
     * 分页查询公开产品列表
     * @param dto 分页查询DTO
     * @return 页结果
     */
    @Override
    public PageResult<ProductListVO> page(ProductPageQueryDTO dto) {
        log.info("公开产品列表：categoryId={}, keyword={}, page={}", dto.getCategoryId(), dto.getKeyword(), dto.getPage());
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<ProductListVO> list = (Page<ProductListVO>)productMapper.listPublic(dto.getKeyword(), dto.getCategoryId());
        // 调用Mapper查询分页结果
        return new PageResult<>(list.getTotal(), list);
    }

    /**
     * 查询公开产品详情
     * @param id 产品ID
     * @return 产品详情VO
     */
    @Override
    public ProductVO detail(Long id) {
        log.info("公开产品详情：id={}", id);
        // 调用Mapper查询产品详情
        ProductVO productVO = productMapper.getById(id);
        // 浏览量+1
        productMapper.incrementViewCount(id);
        return productVO;
    }
}
