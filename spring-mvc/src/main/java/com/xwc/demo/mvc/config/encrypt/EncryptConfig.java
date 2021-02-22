package com.xwc.demo.mvc.config.encrypt;

import com.xwc.demo.mvc.config.encrypt.service.DefaultSecretService;
import com.xwc.demo.mvc.config.encrypt.service.SecretService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @创建人 徐卫超 CC
 * @时间 2021/2/21 19:11
 * @备注 加解密框架配置类
 */
@EnableConfigurationProperties
@Configuration
@Import({EncryptRequestBody.class, EncryptRequestBody.class})
public class EncryptConfig {


    @ConfigurationProperties(prefix = "spring.mvc.encrypt")
    public EncryptProperty encryptProperty() {
        return new EncryptProperty();
    }

    @ConditionalOnBean
    public SecretService secretService() {
        return new DefaultSecretService();
    }
}
