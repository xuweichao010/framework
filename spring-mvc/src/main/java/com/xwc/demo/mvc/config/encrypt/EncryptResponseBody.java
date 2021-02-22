package com.xwc.demo.mvc.config.encrypt;

import com.xwc.demo.mvc.config.encrypt.service.EncryptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 创建人：徐卫超 CC 时间：2021/2/21 20:39 备注：
 */
@RestControllerAdvice
public class EncryptResponseBody implements ResponseBodyAdvice {
    @Autowired
    private EncryptService encryptService;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.hasMethodAnnotation(Encrypt.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Encrypt encrypt = returnType.getMethodAnnotation(Encrypt.class);
        if (encrypt != null) {
            encryptService.encoder(body, request, response, encrypt);
        }

        return body;
    }
}
