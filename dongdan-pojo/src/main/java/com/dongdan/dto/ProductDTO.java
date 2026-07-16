package com.dongdan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * 产品新增 / 编辑请求体
 */
@Data
public class ProductDTO {

    private Long categoryId;      // 所属分类 ID

    @NotBlank(message = "产品名称不能为空")
    private String name;          // 产品名称
    private String coverImage;    // 封面图 URL
    private String imageKeyword;  // 图片替换关键词（SEO/alt）
    private String material;      // 材质
    @Min(value = 1, message = "最小起订量必须大于0")
    private Integer moq;          // 最小起订量
    private String priceHint;     // 价格提示（如：面议）
    private String description;   // 产品描述
    @Min(value = 0, message = "状态值只能为0或1")
    @Max(value = 1, message = "状态值只能为0或1")
    private Integer isVisible;    // 上架状态：1=上架 0=下架
    private Integer sortOrder;    // 排序
    private List<SpecItem> specs;     // 规格参数列表
    private List<ImageItem> images;   // 产品图片列表

    @Data
    public static class SpecItem {
        private String specLabel;
        private String specValue;
        private Integer sortOrder;
    }

    @Data
    public static class ImageItem {
        private String imageUrl;
        private String label;
        private Integer sortOrder;
    }
}
