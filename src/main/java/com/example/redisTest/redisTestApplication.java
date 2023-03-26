package com.example.redisTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableWebMvc
public class redisTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(redisTestApplication.class,args);
    }

}
