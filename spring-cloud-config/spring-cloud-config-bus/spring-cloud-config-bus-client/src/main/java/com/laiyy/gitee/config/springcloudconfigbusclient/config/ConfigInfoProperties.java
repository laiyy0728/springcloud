package com.laiyy.gitee.config.springcloudconfigbusclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author laiyy
 * @date 2019/3/5 9:37
 * @description
 */
@Component
@RefreshScope
public class ConfigInfoProperties {

    @Value("${com.laiyy.gitee.config}")
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
