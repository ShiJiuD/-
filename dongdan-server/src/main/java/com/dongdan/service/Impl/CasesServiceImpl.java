package com.dongdan.service.Impl;

import com.dongdan.mapper.CasesMapper;
import com.dongdan.result.PageResult;
import com.dongdan.service.CasesService;
import com.dongdan.vo.CaseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CasesServiceImpl implements CasesService {

    private final CasesMapper casesMapper;

    /**
     * 分页查询案例列表
     *
     * @param page 页码
     * @param size 每页数量
     * @return 案例列表分页结果
     */
    @Override
    public PageResult<CaseVO> page(Integer page, Integer size) {
        log.info("分页查询案例：page={}, size={}", page, size);
        PageHelper.startPage(page, size);
        List<CaseVO> list = casesMapper.listVisible();
        Page<CaseVO> p = (Page<CaseVO>) list;          // PageHelper 拦截后 list 实际是 Page 子类
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
