package com.dongdan.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private Long id;            // 管理员 ID
    private String username;    // 登录用户名
    private String nickname;    // 显示昵称
    private String token;       // JWT access token
}
