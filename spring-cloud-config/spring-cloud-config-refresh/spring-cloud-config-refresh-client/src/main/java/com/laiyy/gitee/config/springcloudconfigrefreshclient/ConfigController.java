package com.laiyy.gitee.config.springcloudconfigrefreshclient;

import com.laiyy.gitee.config.springcloudconfigrefreshclient.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/3/4 14:07
 * @description
 */
@RestController
@RefreshScope
public class ConfigController {

    private final ConfigInfoProperties configInfoProperties;

    @Autowired
    public ConfigController(ConfigInfoProperties configInfoProperties) {
        this.configInfoProperties = configInfoProperties;
    }

    @GetMapping(value = "/get-config-info")
    public String getConfigInfo(){
        return configInfoProperties.getConfig();
    }

}
