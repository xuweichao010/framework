package com.xwc.demo.mvc.config.encrypt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xwc.demo.commons.mode.JsonMessage;
import com.xwc.demo.mvc.config.encrypt.Encrypt;
import com.xwc.demo.mvc.config.encrypt.model.EncryptHttpInputMessage;
import com.xwc.demo.mvc.config.encrypt.EncryptProperty;
import com.xwc.demo.mvc.config.encrypt.model.Secret;
import com.xwc.demo.mvc.config.encrypt.model.SecretType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
    @Autowired(required = false)
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;


    public HttpInputMessage decoder(HttpInputMessage inputMessage, Encrypt encrypt) {
        //得到秘钥ID
        List<String> secretList = inputMessage.getHeaders().get(encryptProperty.getHeadName());
        if (secretList == null || secretList.isEmpty()) {
            // 自适应环境允许数据不加密传输
            if (encryptProperty.getSelfAdaptionProfiles().contains(profilesActive) && encrypt.selfAdaption()) {
                return inputMessage;
            } else {
                throw new RuntimeException("未发现数据秘钥信息");
            }
        }
        Secret secret = getSecret(secretList.get(0));
        if (encrypt.type() != SecretType.AUTO && secret.type() != encrypt.type()) {
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
    public Object encoder(Object body, ServerHttpRequest request, ServerHttpResponse response, Encrypt encrypt) {
        List<String> headParaList = request.getHeaders().get(encryptProperty.getHeadName());
        SecretType type;
        // 检查http请求信息中是否有加密头
        if (headParaList == null || headParaList.isEmpty()) {
            if (!encrypt.selfAdaption() && encrypt.type() == SecretType.AUTO) {
                throw new RuntimeException("未指定加密方式");
            }
            type = encrypt.type();
        } else {
            //
            if (encrypt.type() == SecretType.AUTO) {
                Secret secret = getSecret(headParaList.get(0));
                type = secret.type();
            } else {
                // 强制使用指定的加密方式
                type = encrypt.type();
            }
        }
        if (type == SecretType.AUTO && encryptProperty.getSelfAdaptionProfiles().contains(profilesActive)) {
            return body;
        }
        Secret secret = secretService.random(type);
        if (body instanceof JsonMessage) {
            JsonMessage<?> jsonMessage = (JsonMessage<?>) body;
            Object data = jsonMessage.getData();
            if (data != null) {
                if (mappingJackson2HttpMessageConverter != null) {
                    try {
                        String encoderContent = secret.encoder(
                                mappingJackson2HttpMessageConverter.getObjectMapper().writeValueAsString(data));
                        return JsonMessage.succeed(encoderContent);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("json格式化异常");
                    }
                }
            }
        } else {
            if (mappingJackson2HttpMessageConverter != null) {
                try {
                    return secret.encoder(
                            mappingJackson2HttpMessageConverter.getObjectMapper().writeValueAsString(body));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("json格式化异常");
                }
            }
        }
        return body;
    }

    public Secret getSecret(String headPram) {
        Secret secret = secretService.get(headPram);
        if (secret == null) {
            throw new RuntimeException("秘钥数据不存在");
        }
        return secret;
    }

    @Override
    public void setEnvironment(Environment environment) {
        profilesActive = environment.getProperty("spring.profiles.active");
    }
}
