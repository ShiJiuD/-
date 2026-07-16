package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.entity.Banner;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.BannerPageVO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannersMapper {

    /**
     * Banner 列表
     * @return Banner 列表VO
     */
    @Select("select * from banner order by sort_order asc")
    List<BannerPageVO> list();

    /**
     * 新增 Banner
     * @param banner Banner 实体
     */
    @AutoFill(OperationType.INSERT)
    void insert(Banner banner);

    /**
     * 更新 Banner
     * @param banner Banner 实体
     */
    @AutoFill(OperationType.UPDATE)
    void update(Banner banner);

    /**
     * 更新 Banner 状态
     * @param id Banner ID
     * @param isVisible 是否可见
     */
    @Update("update banner set is_visible = #{isVisible} where id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("isVisible") Integer isVisible);

    /**
     * 删除 Banner
     * @param id Banner ID
     */
    @Delete("delete from banner where id = #{id}")
    void deleteById(Long id);
}
