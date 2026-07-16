package com.dongdan.dto;

import lombok.Data;

/**
 * 管理端询价分页查询参数
 */
@Data
public class InquiryPageQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer status;   // 0/1/2/3，不传查全部
}