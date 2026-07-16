package com.dongdan.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户端询价进度查询返回
 */
@Data
public class InquiryTrackVO {

    private String inquiryCode;
    private String companyName;
    private String productCategory;
    private String status;          // 中文状态
    private Integer statusCode;     // 原始状态码
    private String remark;          // 管理员备注（已回复可见）
    private String contactName;   // 联系人
    private String phone;          // 联系电话（方便用户确认）
    private LocalDateTime createTime;
}