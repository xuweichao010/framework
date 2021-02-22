package com.xwc.demo.mvc.config.encrypt;

import java.util.concurrent.ScheduledFuture;

/**
 * @创建人 徐卫超 CC
 * @时间 2021/2/21 20:13
 * @备注
 */
public interface Secret {

    /**
     * 秘钥的级别
     *
     * @return
     */
    SecretLevel level();

    /**
     * 秘钥的ID
     */
    String secretId();

    /**
     * 加密信息
     */
    String encoder(String message);

    /**
     * 解密信息
     */
    String decoder(String message);

    /**
     * 加密信息
     */
    byte[] encoder(byte[] message);

    /**
     * 解密信息
     */
    byte[] decoder(byte[] message);

}
