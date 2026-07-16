package com.dongdan.mapper;

import com.dongdan.vo.CaseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CasesMapper {

    /**
     * 查询可见案例列表
     */
    List<CaseVO> listVisible();
}
