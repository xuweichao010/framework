package com.xwc.demo.mvc.config.mvc;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/13 20:50
 * 备注：
 */
public class AppWebMvcConfig implements WebMvcConfigurer {

    /**
     * Controller 方法参数注入
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

}

