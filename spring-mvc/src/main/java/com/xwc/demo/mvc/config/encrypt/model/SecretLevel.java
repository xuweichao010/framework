package com.xwc.demo.mvc.config.encrypt.model;

/**
 * 加密等级 理论上设计为等级越高数据安全系数越高
 */
public enum SecretLevel {
    /**
     * 类似于 BASE64的加密方式
     */
    ONE,
    /**
     * 类似于 对称加密方案
     */
    TWO,
    /**
     * 类似于 非对称加密方案
     */
    THREE,
    /**
     * 类似于 自定义加密方案
     */
    FOUR,

    /**
     * 自动适配加
     */
    AUTO;

}
