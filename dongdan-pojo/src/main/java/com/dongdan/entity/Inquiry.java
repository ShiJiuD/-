package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 询价记录
 * 用户提交后管理员在后台处理
 */
@Data
public class Inquiry {

    private Long id;                  // 主键
    private String inquiryCode;       // 询价编号（RFQ-20260615-001）
    private String companyName;       // 公司名称
    private String contactName;       // 联系人
    private String phone;             // 联系电话
    private String email;             // 邮箱
    private String productCategory;   // 产品品类
    private String quantity;          // 预计数量
    private String description;       // 需求描述
    private Integer status;            // 状态：0=待处理 1=已回复 2=已成交 3=已关闭
    private String remark;            // 管理员备注（用户不可见）
    private LocalDateTime createTime; // 提交时间
    private LocalDateTime updateTime; // 最后更新时间
}
