package com.dongdan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 管理员登录请求体
 */
@Data
public class LoginDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;  // 登录用户名

    @NotBlank(message = "密码不能为空")
    private String password;  // 登录密码
}
