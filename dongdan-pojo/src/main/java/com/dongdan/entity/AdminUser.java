package com.dongdan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 管理员
 */
@Data
public class AdminUser {

    private Long id;                     // 主键
    private String username;             // 登录用户名
    private String password;             // BCrypt 加密密码
    private String nickname;             // 显示昵称
    private String avatar;               // 头像 URL
    private Integer status;              // 1=启用 0=禁用
    private LocalDateTime lastLoginTime; // 最后登录时间
    private String lastLoginIp;          // 最后登录 IP
    private LocalDateTime createTime;    // 创建时间
    private LocalDateTime updateTime;    // 更新时间
}
