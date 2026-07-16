package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 下载中心（扩展预留）
 */
@Data
public class Download {

    private Long id;                  // 主键
    private String title;             // 文件名称
    private String categoryName;      // 分类名
    private String fileUrl;           // 文件下载 URL
    private String fileSize;          // 文件大小
    private Integer downloadCount;    // 下载次数
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
