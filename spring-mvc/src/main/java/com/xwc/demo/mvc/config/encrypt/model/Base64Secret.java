package com.xwc.demo.mvc.config.encrypt.model;


import java.util.Base64;

/**
 * Base64加密数据
 */
public class Base64Secret implements Secret {

    private String secretId;

    public Base64Secret(String secretId) {
        this.secretId = secretId;
    }

    @Override
    public String secretId() {
        return secretId;
    }

    @Override
    public SecretType type() {
        return SecretType.BASE64;
    }

    @Override
    public String encoder(String message) {
        return new String(encoder(message.getBytes()));
    }

    @Override
    public String decoder(String message) {
        return new String(decoder(message.getBytes()));
    }

    @Override
    public byte[] encoder(byte[] message) {
        return Base64.getEncoder().encode(message);
    }

    @Override
    public byte[] decoder(byte[] message) {
        return Base64.getDecoder().decode(message);
    }
}
