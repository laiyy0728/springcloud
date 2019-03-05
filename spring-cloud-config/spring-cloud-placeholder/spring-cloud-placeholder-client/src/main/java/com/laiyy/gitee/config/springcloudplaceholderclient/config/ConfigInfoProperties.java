package com.laiyy.gitee.config.springcloudplaceholderclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author laiyy
 * @date 2019/3/5 14:15
 * @description
 */
@Component
@ConfigurationProperties(prefix = "com.laiyy.gitee")
public class ConfigInfoProperties {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
