package com.dongdan.service;

import com.dongdan.vo.DashboardVO;
import com.dongdan.vo.InquiryPageVO;

import java.util.List;

public interface DashboardService {

    /** 工作台统计数据 */
    DashboardVO getStats();

    /** 最近询价 */
    List<InquiryPageVO> listRecentInquiries(Integer limit);
}
