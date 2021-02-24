package com.xwc.demo.mvc.config.mvc;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/13 20:50
 * 备注：
 */
@RestControllerAdvice
public class AppWebMvcConfig implements WebMvcConfigurer {

    @ExceptionHandler(RuntimeException.class)


    /**
     * Controller 方法参数注入
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

}

