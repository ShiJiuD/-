package com.dongdan.service;

import com.dongdan.result.PageResult;
import com.dongdan.vo.CaseVO;

public interface CasesService {

    /**
     * 分页查询案例列表
     *
     * @param page 页码
     * @param size 每页数量
     * @return 案例列表分页结果
     */
    PageResult<CaseVO> page(Integer page, Integer size);
}
