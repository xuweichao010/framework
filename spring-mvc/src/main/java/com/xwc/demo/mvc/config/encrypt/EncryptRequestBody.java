package com.xwc.demo.mvc.config.encrypt;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 19:47
 * 备注：
 */

public class EncryptRequestBody extends RequestBodyAdviceAdapter {
    /**
     * 秘钥信息
     */
    @Autowired
    private SecretService encryptService;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(Encrypt.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        InputStream is = inputMessage.getBody();
        byte[] data = new byte[is.available()];
        is.read(data);
        Secret secret = encryptService.get("base64_1234");
        new String(secret.decoder(data))
    }


}
