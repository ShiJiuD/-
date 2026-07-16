package com.dongdan.service;

import com.dongdan.dto.CategoryDTO;
import com.dongdan.dto.CategoryPageQueryDTO;
import com.dongdan.dto.CategoryStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.CategoryPageVO;

public interface CategoryService {
    /**
     * 分页查询分类列表
     * @param categoryPageQueryDTO 分页查询DTO
     * @return 分页结果
     */
    PageResult<CategoryPageVO> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 增加分类
     * @param categoryDTO 分类DTO
     */
    void add(CategoryDTO categoryDTO);

    /**
     * 更新分类
     * @param id 分类ID
     * @param categoryDTO 分类DTO
     */
    void update(Long id, CategoryDTO categoryDTO);

    /**
     * 更新分类状态
     * @param id 分类ID
     * @param categoryStatusDTO 分类状态DTO
     */
    void updateStatus(Long id, CategoryStatusDTO categoryStatusDTO);

    /**
     * 删除分类
     * @param id 分类ID
     */
    void deleteById(Long id);
}
