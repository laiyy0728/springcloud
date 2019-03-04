package com.laiyy.gitee.config.springcloudconfigrefreshclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author laiyy
 * @date 2019/3/4 14:09
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
