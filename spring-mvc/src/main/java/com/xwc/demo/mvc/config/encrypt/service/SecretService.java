package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.model.Secret;
import com.xwc.demo.mvc.config.encrypt.model.SecretType;

import java.util.List;

/**
 * 创建人：徐卫超 CC 时间：2021/2/21 19:54 备注：
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
     * 获取一个有加密等级的秘钥
     *
     * @param level
     * @return
     */
    Secret random(SecretType level);

    /**
     * 获取系统中所有的秘钥信息
     *
     * @return
     */
    List<Secret> list();
}
