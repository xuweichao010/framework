package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.model.Secret;

import java.util.List;

/**
 * 创建人：徐卫超 CC 时间：2021/2/21 20:12 备注：
 */
public class DefaultSecretService implements SecretService {


    @Override
    public Secret get(String keyId) {
        return null;
    }

    @Override
    public Secret random() {
        return null;
    }

    @Override
    public Secret random(SecretLevel level) {
        return null;
    }

    @Override
    public List<Secret> list() {
        return null;
    }
}
