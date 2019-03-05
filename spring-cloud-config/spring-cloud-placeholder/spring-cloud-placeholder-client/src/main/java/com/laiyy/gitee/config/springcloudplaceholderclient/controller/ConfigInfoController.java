package com.laiyy.gitee.config.springcloudplaceholderclient.controller;

import com.laiyy.gitee.config.springcloudplaceholderclient.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/3/5 14:16
 * @description
 */
@RestController
public class ConfigInfoController {

    private final ConfigInfoProperties configInfoProperties;

    @Autowired
    public ConfigInfoController(ConfigInfoProperties configInfoProperties) {
        this.configInfoProperties = configInfoProperties;
    }

    @GetMapping(value = "/get-config-info")
    public String getConfigInfo(){
        return configInfoProperties.getConfig();
    }
}
