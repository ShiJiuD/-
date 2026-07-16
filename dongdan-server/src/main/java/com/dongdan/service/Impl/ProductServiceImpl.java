package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.ProductDTO;
import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.dto.ProductStatusDTO;
import com.dongdan.entity.Product;
import com.dongdan.exception.BusinessException;
import com.dongdan.exception.ResourceNotFoundException;
import com.dongdan.mapper.ProductMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.ProductService;
import com.dongdan.vo.ProductPageVO;
import com.dongdan.vo.ProductVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    /**
     * 分页查询产品列表
     * @param pageDto 分页查询DTO
     * @return 分页结果
     */
    @Override
    public PageResult<ProductPageVO> page(ProductPageQueryDTO pageDto) {
        log.info("分页查询产品列表请求：{}页，{}条", pageDto.getPage(), pageDto.getPageSize());
        // 使用分页器
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        // 调用mapper层查询
        Page<ProductPageVO> page = productMapper.page(pageDto);
        // 包装分页结果
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 根据产品ID查询产品详情
     * @param id 产品ID
     * @return 产品详情
     */
    @Override
    public ProductVO getById(Long id) {
        log.info("根据产品ID查询产品详情请求：{}", id);
        // 调用mapper层查询
        ProductVO product = productMapper.getById(id);
        if (product == null) {
            throw new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND);
        }
        return product;
    }

    /**
     * 新增产品
     * @param productDTO 产品DTO
     * @return 新增的产品VO
     */
    @Override
    @Transactional
    public void add(ProductDTO productDTO) {
        log.info("新增产品请求：{}", productDTO);
        // 转换为Product
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        // 调用mapper层新增
        productMapper.insert(product);
        // 调用mapper层新增规格参数
        if (productDTO.getSpecs() != null && !productDTO.getSpecs().isEmpty()) {
            productMapper.insertSpecs(product.getId(), productDTO.getSpecs());
        }
        // 调用mapper层新增图片
        if (productDTO.getImages() != null && !productDTO.getImages().isEmpty()) {
            productMapper.insertImages(product.getId(), productDTO.getImages());
        }

    }

    /**
     * 更新产品
     * @param id 产品ID
     * @param productDTO 产品DTO
     */
    @Override
    @Transactional
    public void update(Long id, ProductDTO productDTO) {
        // 检查产品是否存在
        ProductVO existing = productMapper.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setId(id);
        productMapper.update(product);

        // 先删除旧的规格参数
        productMapper.deleteSpecs(id);
        // 调用mapper层新增规格参数
        if (productDTO.getSpecs() != null && !productDTO.getSpecs().isEmpty()) {
            productMapper.insertSpecs(product.getId(), productDTO.getSpecs());
        }
        // 先删除旧的图片
        productMapper.deleteImages(id);
        // 调用mapper层新增图片
        if (productDTO.getImages() != null && !productDTO.getImages().isEmpty()) {
            productMapper.insertImages(product.getId(), productDTO.getImages());
        }
    }

    /**
     * 删除产品(单条)
     * @param id 产品ID
     */
    @Override
    @Transactional
    public void delete(Long id) {
        log.info("删除产品请求：{}", id);
        // 检查产品是否存在
        ProductVO existing = productMapper.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND);
        }
        // 先删除旧的规格参数
        productMapper.deleteSpecs(id);
        // 先删除旧的图片
        productMapper.deleteImages(id);
        // 调用mapper层删除产品
        productMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteBatch(List<Long> ids) {
        log.info("删除产品请求：{}", ids);
        if (ids == null || ids.isEmpty()) {
            throw new BusinessException(MessageConstant.PRODUCT_DELETE_ERROR);
        }
        // 先删除旧的规格参数
        // 批量删子表 → 批量删主表
        for (Long id : ids) {
            // 先删除旧的规格参数
            productMapper.deleteSpecs(id);
            // 先删除旧的图片
            productMapper.deleteImages(id);
        }
        // 调用mapper层删除产品
        productMapper.deleteBatch(ids);
    }

    /**
     * 更新产品上下架状态
     * @param id 产品ID
     * @param statusDTO 产品状态DTO
     */
    @Override
    @Transactional
    public void updateStatus(Long id, ProductStatusDTO statusDTO) {
        log.info("更新产品上下架状态请求：{}, {}", id, statusDTO);
        // 检查产品是否存在
        ProductVO existing = productMapper.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND);
        }
        Product product = new Product();
        product.setId(id);
        product.setIsVisible(statusDTO.getIsVisible());
        // 调用mapper层更新上下架状态
        productMapper.updateStatus(product);
    }

}
