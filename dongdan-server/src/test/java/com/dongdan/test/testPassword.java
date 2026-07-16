package com.dongdan.test;


import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class testPassword {
    @Test
    public void testPassword() {
        // 测试密码加密
        String password = BCrypt.hashpw("DongDan0608", BCrypt.gensalt());
        System.out.println(password);
    }
}
