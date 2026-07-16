package com.dongdan.mapper;

import com.dongdan.vo.DashboardVO;
import com.dongdan.vo.InquiryPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DashboardMapper {

    /** 工作台统计数据 */
    DashboardVO getStats();

    /** 最近询价 */
    List<InquiryPageVO> listRecentInquiries(Integer limit);
}
