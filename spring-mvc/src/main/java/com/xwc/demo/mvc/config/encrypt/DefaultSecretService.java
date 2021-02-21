package com.xwc.demo.mvc.config.encrypt;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 20:12
 * 备注：
 */
public class DefaultSecretService implements SecretService{
    @Autowired
    private List<>

    @Override
    public Object get(String keyId) {
        return null;
    }

    @Override
    public Object random() {
        return null;
    }

    @Override
    public Object random(SecretLevel level) {
        return null;
    }

    @Override
    public List<Object> list() {
        return null;
    }
}
