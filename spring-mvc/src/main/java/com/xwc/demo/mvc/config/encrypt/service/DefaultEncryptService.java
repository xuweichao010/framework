package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.Encrypt;
import com.xwc.demo.mvc.config.encrypt.model.EncryptHttpInputMessage;
import com.xwc.demo.mvc.config.encrypt.EncryptProperty;
import com.xwc.demo.mvc.config.encrypt.model.Secret;
import com.xwc.demo.mvc.config.encrypt.model.SecretLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DefaultEncryptService implements EncryptService, EnvironmentAware {
    private String profilesActive;

    @Autowired
    private SecretService secretService;
    @Autowired
    private EncryptProperty encryptProperty;


    public HttpInputMessage decoder(HttpInputMessage inputMessage, Encrypt encrypt) {
        //得到秘钥ID
        List<String> secretList = inputMessage.getHeaders().get(encryptProperty.getHeadName());
        if (secretList == null || secretList.isEmpty()) {
            // 自适应环境允许数据不加密传输
            if (encryptProperty.getSelfAdaption().contains(profilesActive)) {
                return inputMessage;
            } else {
                throw new RuntimeException("未发现数据秘钥信息");
            }
        }
        String secretId = secretList.get(0);
        Secret secret = secretService.get(secretId);
        if (encrypt.level() != SecretLevel.AUTO && secret.level() != encrypt.level()) {
            throw new RuntimeException("秘钥校验错误");
        }
        try {
            // 提取数据
            InputStream is = inputMessage.getBody();
            byte[] data = new byte[is.available()];
            if (data.length == 0) {
                return inputMessage;
            }
            is.read(data);
            byte[] decoderData = secret.decoder(data);
            return new EncryptHttpInputMessage(new ByteArrayInputStream(decoderData), inputMessage.getHeaders());
        } catch (IOException e) {
            throw new RuntimeException("解密数据错误");
        }
    }

    @Override
    public void encoder(Object body, ServerHttpRequest request, ServerHttpResponse response, Encrypt encrypt) {

    }

    @Override
    public void setEnvironment(Environment environment) {
        profilesActive = environment.getProperty("spring.profiles.active");
    }
}
