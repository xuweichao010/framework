package com.xwc.demo.mvc.config.encrypt.model;

/**
 * 系统支持的加密方案
 */
public enum SecretType {
    /**
     * 类似于 BASE64的加密方式
     */
    BASE64,
    /**
     * 自定义加密方案
     */
    DES,
    /**
     * 非对称加密方案
     */
    RSA,
    /**
     * 类似于 自定义加密方案
     */
    CUSTOM,

    /**
     * 根据参数自动适配
     */
    AUTO;

}
