package com.xwc.demo.mvc.config.encrypt;

import com.xwc.demo.mvc.config.encrypt.service.EncryptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 19:47
 * 备注：
 */

@RestControllerAdvice
public class EncryptRequestBody extends RequestBodyAdviceAdapter {
    /**
     * 秘钥信息
     */
    @Autowired
    private EncryptService encryptService;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(Encrypt.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        Encrypt encrypt = parameter.getParameterAnnotation(Encrypt.class);
        if (encrypt != null) {
            return encryptService.decoder(inputMessage, encrypt);
        }
        return inputMessage;
    }

}
