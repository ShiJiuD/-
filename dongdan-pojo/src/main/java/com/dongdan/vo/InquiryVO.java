package com.dongdan.vo;

import lombok.Data;

/**
 * 询价记录 — 返回给前端的数据
 */
@Data
public class InquiryVO {

    private Long id;         // 询价 ID
    private String company;  // 公司名称
    private String contact;  // 联系人
    private String phone;    // 联系电话
    private String product;  // 产品名称
    private String date;     // 提交日期
    private String status;   // 处理状态
}
