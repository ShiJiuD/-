package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.entity.Milestone;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.MilestonePageVO;
import com.dongdan.vo.MilestoneVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MilestoneMapper {

    /** 公开列表（仅可见） */
    List<MilestoneVO> listVisible();

    /** 管理端全量列表 */
    List<MilestonePageVO> listAdmin();

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    void insert(Milestone milestone);

    /** 编辑 */
    @AutoFill(value = OperationType.UPDATE)
    void update(Milestone milestone);

    /** 启用禁用 */
    void updateStatus(@Param("id") Long id, @Param("isVisible") Integer isVisible);

    /** 删除 */
    @Delete("DELETE FROM milestone WHERE id = #{id}")
    void deleteById(@Param("id") Long id);
}
