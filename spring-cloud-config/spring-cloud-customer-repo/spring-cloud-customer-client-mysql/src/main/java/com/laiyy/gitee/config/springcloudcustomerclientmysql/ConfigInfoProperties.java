package com.laiyy.gitee.config.springcloudcustomerclientmysql;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author laiyy
 * @date 2019/3/4 14:09
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
