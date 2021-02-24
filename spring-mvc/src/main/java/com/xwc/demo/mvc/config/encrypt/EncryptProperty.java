package com.xwc.demo.mvc.config.encrypt;

import java.util.Arrays;
import java.util.HashSet;

import lombok.Data;

/**
 * 创建人：徐卫超 CC 时间：2021/2/21 19:36 备注：
 */
@Data
public class EncryptProperty {

    /**
     * 在指定环境下支持加密数据解析也支持非加密数据解析, 方便开发者调试使用 主要是根据请求体信息中是否包含 spring.mvc.
     *
     * @return
     */
    private HashSet<String> selfAdaptionProfiles = new HashSet<>(Arrays.asList("dev"));

    /**
     * 用于传输秘钥信息请求体
     */
    private String headName = "X_Encrypt";

}
