package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.model.Secret;

import java.util.List;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 19:54
 * 备注：
 */
public interface SecretService {

    /**
     * 根据秘钥标识 获取加密的秘钥信息。
     *
     * @param keyId 秘钥标识信息
     * @return
     */
    Secret get(String keyId);

    /**
     * 随机一个秘钥信息
     *
     * @return
     */
    Secret random();

    /**
     * 获取一个有加密等级的秘钥
     *
     * @param level
     * @return
     */
    Secret random(SecretLevel level);

    /**
     * 获取系统中所有的秘钥信息
     *
     * @return
     */
    List<Secret> list();

    /**
     * 加密等级 理论上设计为等级越高数据安全系数越高
     */
    enum SecretLevel {
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
        FOUR;
    }
}
