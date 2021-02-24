package com.xwc.demo.mvc.config.encrypt;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：CC 时间：2020/8/31 9:04 描述：支持系统加解密方案
 */
@Target({ElementType.TYPE,})
@Retention(RetentionPolicy.RUNTIME)
@Import(EncryptConfig.class)
public @interface EnableEncrypt {
}
