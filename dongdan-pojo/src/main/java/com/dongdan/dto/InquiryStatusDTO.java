package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 询价状态流转请求体
 */
@Data
public class InquiryStatusDTO {

    @NotNull(message = "状态不能为空")
    @Min(value = 0, message = "状态值 0-3")
    @Max(value = 3, message = "状态值 0-3")
    private Integer status;
}