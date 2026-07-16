package com.dongdan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.dongdan")
//@MapperScan("com.dongdan.mapper")  // 扫描 mapper 接口，自动创建实现类 mapper接口可以不写@Mapper注解
@EnableAsync
public class DongdanApplication {
    public static void main(String[] args) {
        SpringApplication.run(DongdanApplication.class, args);
    }
}
