package com.dongdan.service.Impl;

import com.dongdan.mapper.DashboardMapper;
import com.dongdan.service.DashboardService;
import com.dongdan.vo.DashboardVO;
import com.dongdan.vo.InquiryPageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    private final DashboardMapper dashboardMapper;

    /** 工作台统计数据 */
    @Override
    public DashboardVO getStats() {
        log.info("获取工作台统计数据");
        return dashboardMapper.getStats();
    }

    /** 最近询价 */
    @Override
    public List<InquiryPageVO> listRecentInquiries(Integer limit) {
        log.info("获取最近询价，limit={}", limit);
        List<InquiryPageVO> list = dashboardMapper.listRecentInquiries(limit);
        // 填充中文状态
        for (InquiryPageVO vo : list) {
            vo.setStatusText(getStatusText(vo.getStatus()));
        }
        return list;
    }


    /**
     * 状态码 → 中文
     * 和 InquiryServiceImpl 里的方法完全一样。
     * 为了避免循环依赖，Dashboard 模块自己写一份。
     */
    private String getStatusText(Integer code) {
        switch (code) {
            case 0: return "待处理";
            case 1: return "已回复";
            case 2: return "已成交";
            case 3: return "已关闭";
            default: return "未知";
        }
    }
}
