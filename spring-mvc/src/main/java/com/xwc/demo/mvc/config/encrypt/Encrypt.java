package com.xwc.demo.mvc.config.encrypt;


import com.xwc.demo.mvc.config.encrypt.model.SecretType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：CC 时间：2020/8/31 9:04 描述：
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {

    /**
     * 自动选择加密方案
     */
    SecretType type() default SecretType.AUTO;

    /**
     * 自适应功能 true:开启  false:关闭
     */
    boolean selfAdaption() default false;
}
