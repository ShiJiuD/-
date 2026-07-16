package com.dongdan.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * 批量删除请求体
 */
@Data
public class BatchDeleteDTO {

    /**
     * 待删除id集合
     */
    @NotEmpty(message = "请至少选择一条记录")
    private List<Long> ids;
}