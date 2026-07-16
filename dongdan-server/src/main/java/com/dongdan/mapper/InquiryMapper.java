package com.dongdan.mapper;

import com.dongdan.entity.Inquiry;
import com.dongdan.vo.InquiryPageVO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InquiryMapper {

    /**
     * 根据日期查询最大询价编码
     * @param date 日期
     * @return 最大询价编码
     */
    @Select("SELECT inquiry_code FROM inquiry WHERE inquiry_code LIKE CONCAT('RFQ-', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String selectMaxCodeByDate(String date);

    /**
     * 插入询价
     * @param inquiry 询价
     */
    void insert(Inquiry inquiry);

    /**
     * 根据询价编码查询询价
     * @param code 询价编码
     * @return 询价
     */
    @Select("SELECT * FROM inquiry WHERE inquiry_code = #{code}")
    Inquiry selectByInquiryCode(String code);

    /**
     * 管理员分页查询询价
     * @param status 状态码
     * @return 询价分页列表
     */
    List<InquiryPageVO> pageAdmin(Integer status);

    /**
     * 更新询价状态
     * @param id 询价ID
     * @param status 状态码
     */
    @Update("UPDATE inquiry SET status = #{status} WHERE id = #{id}")
    void updateStatus(Long id, @NotNull(message = "状态不能为空") @Min(value = 0, message = "状态值 0-3") @Max(value = 3, message = "状态值 0-3") Integer status);
}
