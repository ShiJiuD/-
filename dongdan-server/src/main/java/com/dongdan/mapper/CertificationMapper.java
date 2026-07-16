package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.CertificationPageQueryDTO;
import com.dongdan.entity.Certification;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.CertificationPageVO;
import com.dongdan.vo.CertificationVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CertificationMapper {

    /** 公开列表（仅已显示，按排序升序） */
    @Select("SELECT id, name, image_url, image_keyword FROM certification WHERE is_visible = 1 ORDER BY sort_order ASC")
    List<CertificationVO> listVisible();

    /** 根据 ID 查询（管理端用，含完整字段） */
    @Select("SELECT id, name, image_url, image_keyword, sort_order, is_visible, create_time FROM certification WHERE id = #{id}")
    CertificationPageVO selectById(Long id);

    /** 管理端分页列表（含隐藏 + 搜索） */
    List<CertificationPageVO> page(CertificationPageQueryDTO dto);

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    void insert(Certification cert);

    /** 编辑（动态更新） */
    @AutoFill(value = OperationType.UPDATE)
    void update(Certification cert);

    /** 删除 */
    @Delete("DELETE FROM certification WHERE id = #{id}")
    void deleteById(Long id);
}
