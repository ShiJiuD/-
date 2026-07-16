package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.CasePageQueryDTO;
import com.dongdan.entity.CustomerCase;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.CasePageVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CaseManageMapper {

    /** 管理端分页列表（含隐藏 + 搜索） */
    List<CasePageVO> page(CasePageQueryDTO dto);

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    int insert(CustomerCase c);

    /** 编辑 */
    @AutoFill(value = OperationType.UPDATE)
    int update(CustomerCase c);

    /** 启用禁用 */
    int updateStatus(@Param("id") Long id, @Param("isVisible") Integer isVisible);

    /** 删除 */
    @Delete("DELETE FROM customer_case WHERE id = #{id}")
    int deleteById(@Param("id") Long id);
}