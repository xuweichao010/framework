package com.xwc.demo.mvc.config.encrypt.service;

import com.xwc.demo.mvc.config.encrypt.Encrypt;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

public interface EncryptService {

    /**
     * 解密数据
     *
     * @param inputMessage
     * @param encrypt
     * @return
     */
    HttpInputMessage decoder(HttpInputMessage inputMessage, Encrypt encrypt);

    /**
     * 加密数据
     *
     * @param body
     * @param request
     * @param response
     * @param encrypt
     */
    void encoder(Object body, ServerHttpRequest request, ServerHttpResponse response, Encrypt encrypt);
}
