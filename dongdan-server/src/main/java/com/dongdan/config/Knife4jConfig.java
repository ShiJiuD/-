package com.dongdan.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j 接口文档配置
 *
 * 启动后访问：http://localhost:8080/doc.html
 *
 * 外卖项目用 Docket（Swagger 2），
 * Spring Boot 3.x 用 OpenAPI（Swagger 3），
 * 作用一样：给文档起标题、写描述、放联系人信息。
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("东丹服饰官网 API")          // 文档大标题
                        .description("用户端 + 商家端接口") // 描述
                        .version("v1.0")                   // 版本号
                        .contact(new Contact()
                                .name("东丹服饰")           // 联系人
                                .email("info@38.76.195.85"))); // 联系邮箱
    }
}
