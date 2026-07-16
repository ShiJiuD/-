package com.dongdan.mapper;


import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.ProductDTO;
import com.dongdan.dto.ProductPageQueryDTO;
import com.dongdan.entity.Product;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.ProductListVO;
import com.dongdan.vo.ProductPageVO;
import com.dongdan.vo.ProductVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 分页查询产品列表
     * @param pageDto
     * @return
     */
    Page<ProductPageVO> page(ProductPageQueryDTO pageDto);

    /**
     * 根据产品ID查询产品详情
     * @param id 产品ID
     * @return 产品详情
     */
    ProductVO getById(Long id);

    /**
     * 新增产品
     * @param product 产品实体
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Product product);

    /**
     * 新增产品规格参数
     * @param productId 产品ID
     * @param specs 规格参数列表
     */
    void insertSpecs(@Param("productId") Long productId, @Param("specs") List<ProductDTO.SpecItem> specs);

    /**
     * 新增产品图片
     * @param productId 产品ID
     * @param images 产品图片列表
     */
    void insertImages(@Param("productId") Long productId, @Param("images") List<ProductDTO.ImageItem> images);

    /**
     * 更新产品
     * @param product 产品实体
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Product product);

    /**
     * 删除产品规格参数
     * @param id 产品ID
     */
    @Delete("DELETE FROM product_spec WHERE product_id = #{id}")
    void deleteSpecs(@Param("id") Long id);

    /**
     * 删除产品图片
     * @param id 产品ID
     */
    @Delete("DELETE FROM product_image WHERE product_id = #{id}")
    void deleteImages(@Param("id") Long id);

    /**
     * 根据产品ID删除产品
     * @param id 产品ID
     */
    @Delete("DELETE FROM product WHERE id = #{id}")
    void deleteById(@Param("id") Long id);

    /**
     * 删除产品(批量)
     * @param ids 产品ID列表
     */
    void deleteBatch(List<Long> ids);

    /**
     * 更新产品上下架状态
     *
     * @param product 产品实体
     */
    @AutoFill(value = OperationType.UPDATE)
    @Update("UPDATE product SET is_visible = #{isVisible}, update_time = #{updateTime} WHERE id = #{id}")
    void updateStatus(Product product);

    /**
     * 分页查询公开产品列表
     * @param keyword 搜索关键词
     * @param categoryId 分类ID
     * @return 页结果
     */
    List<ProductListVO> listPublic(String keyword, Long categoryId);

    /**
     * 更新产品浏览量
     * @param id 产品ID
     */
    @Update("UPDATE product SET view_count = view_count + 1 WHERE id = #{id}")
    void incrementViewCount(Long id);

}
