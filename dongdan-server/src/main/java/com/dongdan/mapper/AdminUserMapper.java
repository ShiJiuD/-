package com.dongdan.mapper;

import com.dongdan.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminUserMapper {

    /**
     * 根据用户名查询管理员用户
     * @param username 用户名
     * @return 管理员用户
     */
    @Select("select * from admin_user where username = #{username}")
    AdminUser getByUserName(String username);

    /** 按 ID 查管理员 */
    @Select("SELECT * FROM admin_user WHERE id = #{id}")
    AdminUser getById(@Param("id") Long id);

    /** 修改密码 */
    @Update("UPDATE admin_user SET password = #{password} WHERE id = #{id}")
    int updatePassword(@Param("id") Long id, @Param("password") String password);

}
