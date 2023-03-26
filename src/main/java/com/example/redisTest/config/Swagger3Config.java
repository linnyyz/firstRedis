package com.example.redisTest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;


@Configuration
public class Swagger3Config {

    /**
     * 配置swagger的Docket bean
     *
     * @return
     */
    @Bean
    public Docket createRestApi1() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("测试组1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.redisTest.controller.one"))
//                .paths(PathSelectors.ant("/"))
                .build()
                //指定swagger3.0版本
                .apiInfo(createApiInfo1()).enable(true);
    }
    /**
     * 配置swagger的Docket bean
     *
     * @return
     */
    @Bean
    public Docket createRestApi2() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("测试组2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.redisTest.controller.two"))
//                .paths(PathSelectors.ant("/"))
                .build()
                //指定swagger3.0版本
                .apiInfo(createApiInfo2()).enable(true);
    }

    @Bean
    public ApiInfo createApiInfo1() {
        return new ApiInfo("SwaggerTest1",
                "firstSwagger",
                "1.0",
                "http://www.4399.com",
                new Contact("linny", "http://www.4399.com", "1260866126@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    @Bean
    public ApiInfo createApiInfo2() {
        return new ApiInfo("SwaggerTest2",
                "firstSwagger",
                "1.0",
                "http://www.4399.com",
                new Contact("lin", "http://www.4399.com", "1260866126@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
