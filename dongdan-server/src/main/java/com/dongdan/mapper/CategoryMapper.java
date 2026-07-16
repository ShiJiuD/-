package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.CategoryPageQueryDTO;
import com.dongdan.entity.Category;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.CategoryPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 分页查询品类
     * @param categoryPageQueryDTO 分页查询参数
     * @return 分页结果
     */
    List<CategoryPageVO> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 新增品类
     * @param category 品类
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);

    /**
     * 更新品类
     * @param category 品类
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 根据ID查询品类
     * @param id 品类ID
     * @return 品类下的产品数量
     */
    @Select("SELECT count(*) FROM product WHERE category_id = #{id}")
    Long selectCountByCategoryId(Long id);

    /**
     * 删除品类
     * @param id 品类ID
     */
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteById(Long id);


}
