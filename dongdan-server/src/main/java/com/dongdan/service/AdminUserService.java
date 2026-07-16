package com.dongdan.service;

import com.dongdan.dto.ChangePasswordDTO;
import com.dongdan.dto.LoginDTO;
import com.dongdan.entity.AdminUser;
import com.dongdan.vo.LoginVO;

public interface AdminUserService {

    /** 登录：校验用户名密码，成功返回 LoginVO（含 token + 用户信息） */
    LoginVO login(LoginDTO dto);

    /** 按 ID 查管理员 */
    AdminUser getById(Long id);

    /** 修改密码：校验旧密码，更新为新密码 */
    void changePassword(Long userId, ChangePasswordDTO dto);
}
