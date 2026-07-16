package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.entity.Advantage;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.AdvantagePageVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvantagesMapper {
    /** 全量列表 */
    List<AdvantagePageVO> list();

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    void insert(Advantage advantage);

    /** 编辑 */
    @AutoFill(value = OperationType.UPDATE)
    void update(Advantage advantage);

    /** 启用禁用 */
    void updateStatus(@Param("id") Long id, @Param("isVisible") Integer isVisible);

    /** 删除 */
    @Delete("DELETE FROM advantage WHERE id = #{id}")
    void deleteById(Long id);
}
