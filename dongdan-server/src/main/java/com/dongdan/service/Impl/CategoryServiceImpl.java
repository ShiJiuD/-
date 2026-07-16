package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.CategoryDTO;
import com.dongdan.dto.CategoryPageQueryDTO;
import com.dongdan.dto.CategoryStatusDTO;
import com.dongdan.entity.Category;
import com.dongdan.exception.BusinessException;
import com.dongdan.mapper.CategoryMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.CategoryService;
import com.dongdan.vo.CategoryPageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    /**
     * 分页查询分类列表
     * @param categoryPageQueryDTO 分页查询DTO
     * @return 分页结果
     */
    @Override
    public PageResult<CategoryPageVO> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询品类列表，参数：{}", categoryPageQueryDTO);
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<CategoryPageVO> page = (Page<CategoryPageVO>)categoryMapper.page(categoryPageQueryDTO);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 增加分类
     * @param categoryDTO 分类DTO
     */
    @Override
    public void add(CategoryDTO categoryDTO) {
        log.info("新增品类，参数：{}", categoryDTO);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        categoryMapper.insert(category);
    }

    /**
     * 更新分类
     * @param id 分类ID
     * @param categoryDTO 分类DTO
     */
    @Override
    public void update(Long id, CategoryDTO categoryDTO) {
        log.info("更新品类，参数：{}", categoryDTO);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setId(id);
        categoryMapper.update(category);
    }

    /**
     * 更新分类状态
     * @param id 分类ID
     * @param categoryStatusDTO 分类状态DTO
     */
    @Override
    public void updateStatus(Long id, CategoryStatusDTO categoryStatusDTO) {
        log.info("更新品类状态，参数：{}, {}", id, categoryStatusDTO);
        Category category = new Category();
        category.setIsVisible(categoryStatusDTO.getIsVisible());
        category.setId(id);
        categoryMapper.update(category);
    }

    /**
     * 删除分类
     * @param id 分类ID
     */
    @Override
    public void deleteById(Long id) {
        log.info("删除品类，参数：{}", id);
        // 先检查是否存在该分类下的产品
        Long count = categoryMapper.selectCountByCategoryId(id);
        if (count > 0) {
            throw new BusinessException(MessageConstant.CATEGORY_DELETE_ERROR_WITH_PRODUCT);
        }
        categoryMapper.deleteById(id);
    }
}
