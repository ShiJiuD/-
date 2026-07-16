package com.dongdan.service;

import com.dongdan.dto.NewsDTO;
import com.dongdan.dto.NewsPageQueryDTO;
import com.dongdan.dto.NewsStatusDTO;
import com.dongdan.result.PageResult;
import com.dongdan.vo.NewsPageVO;
import com.dongdan.vo.NewsVO;

public interface NewsService {

    /** 公开列表（仅已发布，分页） */
    PageResult<NewsVO> pagePublic(Integer page, Integer size);

    /** 新闻详情 + 浏览量 +1 */
    NewsVO getDetail(Long id);

    /** 管理端列表（含隐藏，分页 + 搜索） */
    PageResult<NewsPageVO> pageAdmin(NewsPageQueryDTO dto);

    /** 管理端详情（含 content + categoryName） */
    NewsPageVO getAdminDetail(Long id);

    /** 新增 */
    void save(NewsDTO dto);

    /** 编辑 */
    void update(Long id, NewsDTO dto);

    /** 发布/隐藏 */
    void updateStatus(Long id, NewsStatusDTO dto);

    /** 删除 */
    void deleteById(Long id);
}