package com.dongdan.service.Impl;

import com.dongdan.constant.MessageConstant;
import com.dongdan.dto.NewsDTO;
import com.dongdan.dto.NewsPageQueryDTO;
import com.dongdan.dto.NewsStatusDTO;
import com.dongdan.entity.News;
import com.dongdan.exception.ResourceNotFoundException;
import com.dongdan.mapper.NewsMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.NewsService;
import com.dongdan.vo.NewsPageVO;
import com.dongdan.vo.NewsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;

    @Override
    public PageResult<NewsVO> pagePublic(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Page<NewsVO> p = (Page<NewsVO>) newsMapper.listPublic();
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public NewsVO getDetail(Long id) {
        NewsVO vo = newsMapper.getDetail(id);
        if (vo == null) {
            throw new ResourceNotFoundException(MessageConstant.NEWS_NOT_FOUND);
        }
        newsMapper.incrementViewCount(id);
        vo.setViewCount(vo.getViewCount() + 1);
        return vo;
    }

    @Override
    public PageResult<NewsPageVO> pageAdmin(NewsPageQueryDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<NewsPageVO> p = (Page<NewsPageVO>) newsMapper.listAdmin(dto);
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public NewsPageVO getAdminDetail(Long id) {
        NewsPageVO vo = newsMapper.getAdminDetail(id);
        if (vo == null) {
            throw new ResourceNotFoundException(MessageConstant.NEWS_NOT_FOUND);
        }
        return vo;
    }

    @Override
    public void save(NewsDTO dto) {
        News news = new News();
        BeanUtils.copyProperties(dto, news);
        news.setViewCount(0);
        if (dto.getIsVisible() == null) {
            news.setIsVisible(1);
        }
        newsMapper.insert(news);
    }

    @Override
    public void update(Long id, NewsDTO dto) {
        News news = new News();
        BeanUtils.copyProperties(dto, news);
        news.setId(id);
        newsMapper.update(news);
    }

    @Override
    public void updateStatus(Long id, NewsStatusDTO dto) {
        newsMapper.updateStatus(id, dto.getIsVisible());
    }

    @Override
    public void deleteById(Long id) {
        newsMapper.deleteById(id);
    }
}