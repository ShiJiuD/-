package com.dongdan.mapper;

import com.dongdan.annotation.AutoFill;
import com.dongdan.dto.NewsPageQueryDTO;
import com.dongdan.entity.News;
import com.dongdan.enumeration.OperationType;
import com.dongdan.vo.NewsPageVO;
import com.dongdan.vo.NewsVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NewsMapper {

    /** 公开列表（仅已发布） */
    List<NewsVO> listPublic();

    /** 查详情（仅已发布） */
    NewsVO getDetail(@Param("id") Long id);

    /** 浏览量 +1 */
    @Update("UPDATE news SET view_count = view_count + 1 WHERE id = #{id}")
    void incrementViewCount(@Param("id") Long id);

    /** 管理端列表（含隐藏 + 搜索） */
    List<NewsPageVO> listAdmin(NewsPageQueryDTO dto);

    /** 管理端详情（含 content + categoryName，不限制 is_visible） */
    NewsPageVO getAdminDetail(@Param("id") Long id);

    /** 新增 */
    @AutoFill(value = OperationType.INSERT)
    void insert(News news);

    /** 编辑 */
    @AutoFill(value = OperationType.UPDATE)
    void update(News news);

    /** 发布/隐藏 */
    void updateStatus(@Param("id") Long id, @Param("isVisible") Integer isVisible);

    /** 删除 */
    @Delete("DELETE FROM news WHERE id = #{id}")
    void deleteById(@Param("id") Long id);
}