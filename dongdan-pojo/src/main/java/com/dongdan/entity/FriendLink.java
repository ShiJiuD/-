package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 友情链接（扩展预留）
 */
@Data
public class FriendLink {

    private Long id;                  // 主键
    private String name;              // 网站名称
    private String url;               // 链接地址
    private Integer sortOrder;        // 排序
    private Integer isVisible;        // 1=显示 0=隐藏
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
