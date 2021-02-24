package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.model.Base64Secret;
import com.xwc.demo.mvc.config.encrypt.model.Secret;
import com.xwc.demo.mvc.config.encrypt.model.SecretType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

/**
 * 创建人：徐卫超 CC 时间：2021/2/21 20:12 备注：
 */
public class DefaultSecretService implements SecretService {

    /**
     * 根据加密类型存储加密数据
     */
    private Map<SecretType, List<Secret>> secretTypeMap = new HashMap<>();

    /**
     * 根据加密ID来存储加密数据
     */
    private Map<String, Secret> secretIdMap = new HashMap<>();


    private Random random = new Random();

    @PostConstruct
    public void init() {
        this.list().stream().forEach(secret -> {
            List<Secret> secretList = secretTypeMap.computeIfAbsent(secret.type(), f -> new ArrayList<>());
            secretList.add(secret);
            secretIdMap.put(secret.secretId(), secret);
        });
    }


    @Override
    public Secret get(String secretId) {
        return secretIdMap.get(secretId);
    }


    @Override
    public Secret random(SecretType type) {
        List<Secret> secretList = secretTypeMap.get(type);
        return secretList.get(random.nextInt(secretList.size()));
    }

    @Override
    public List<Secret> list() {
        return Arrays.asList(new Base64Secret("base64"), new Base64Secret("1231231"));
    }


}
