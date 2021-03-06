package com.xwc.demo.mvc.config.encrypt.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/21 19:49
 * 备注：
 */
public class EncryptHttpInputMessage implements HttpInputMessage {

    private final InputStream body;

    private final HttpHeaders headers;

    public EncryptHttpInputMessage(InputStream body, HttpHeaders headers) {
        this.body = body;
        this.headers = headers;
    }


    @Override
    public InputStream getBody() throws IOException {
        return body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }
}
