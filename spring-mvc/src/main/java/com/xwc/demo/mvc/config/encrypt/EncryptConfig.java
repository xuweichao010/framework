package com.xwc.demo.mvc.config.encrypt;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 19:11
 * 备注：
 */
@EnableConfigurationProperties
@Configuration
public class EncryptConfig {

    @ConfigurationProperties(prefix = "spring.mvc.encrypt")
    public EncryptProperty encryptProperty() {
        return new EncryptProperty();
    }

    @ConditionalOnBean
    public SecretService secretService(){
        new DefaultSecretService();
    }


}
