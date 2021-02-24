package com.xwc.demo.mvc;


import com.xwc.demo.mvc.config.encrypt.EnableEncrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 创建人：徐卫超 CC 时间：2021/2/13 20:36 备注：
 */
@SpringBootApplication
@EnableScheduling
@EnableOpenApi
@EnableEncrypt
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
