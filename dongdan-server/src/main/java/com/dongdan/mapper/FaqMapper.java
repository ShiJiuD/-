package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.FaqPageQueryDTO;
import com.dongdan.entity.Faq;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.FaqPageVO;
import com.dongdan.vo.FaqVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FaqMapper {

    /** 公开列表（仅已显示，按排序升序） */
    @Select("SELECT id, question, answer, sort_order FROM faq WHERE is_visible = 1 ORDER BY sort_order ASC")
    List<FaqVO> listVisible();

    /** 根据 ID 查询（管理端用，含 is_visible + create_time） */
    @Select("SELECT id, question, answer, sort_order, is_visible, create_time FROM faq WHERE id = #{id}")
    FaqPageVO selectById(Long id);

    /** 管理端分页列表（含隐藏 + 搜索） */
    List<FaqPageVO> page(FaqPageQueryDTO dto);

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    void insert(Faq faq);

    /** 编辑（动态更新） */
    @AutoFill(value = OperationType.UPDATE)
    void update(Faq faq);

    /** 删除 */
    @Delete("DELETE FROM faq WHERE id = #{id}")
    void deleteById(Long id);
}
