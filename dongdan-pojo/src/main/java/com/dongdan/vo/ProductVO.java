package com.dongdan.vo;

import lombok.Data;
import java.util.List;

/**
 * 产品详情 — 返回给前端的数据
 */
@Data
public class ProductVO {

    private Long id;                // 产品 ID
    private Long categoryId;        // 所属分类 ID（编辑回显用）
    private String name;            // 产品名称
    private String categoryName;    // 所属分类名称
    private String image;           // 封面图 URL
    private String imageKeyword;    // 图片替换关键词
    private String material;        // 材质
    private Integer moq;            // 最小起订量
    private String priceHint;       // 价格提示（编辑回显用）
    private String description;     // 产品描述
    private Integer isVisible;      // 上架状态（编辑回显用）
    private Integer sortOrder;      // 排序（编辑回显用）
    private List<SpecVO> specs;     // 规格参数列表
    private List<ImageVO> images;   // 图片列表

    /**
     * 规格参数项
     */
    @Data
    public static class SpecVO {
        private String label;       // 参数名（如：面料成分）
        private String value;       // 参数值（如：100%纯棉）
    }

    @Data
    public static class ImageVO {
        private Long id;
        private String imageUrl;
        private String label;
        private Integer sortOrder;
    }
}
