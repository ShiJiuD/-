package com.dongdan.mapper;

import com.dongdan.entity.OperationLog;
import com.dongdan.vo.LogPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperationLogMapper {

    /** 异步写入日志 */
    void insert(OperationLog log);

    /** 分页查询日志 */
    List<LogPageVO> page(@Param("keyword") String keyword,
                         @Param("adminName") String adminName,
                         @Param("type") String type);
}
