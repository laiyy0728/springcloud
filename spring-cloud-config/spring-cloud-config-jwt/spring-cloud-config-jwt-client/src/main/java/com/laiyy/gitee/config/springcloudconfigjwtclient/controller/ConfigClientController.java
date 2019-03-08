package com.laiyy.gitee.config.springcloudconfigjwtclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/3/8 10:06
 * @description
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${com.laiyy.gitee.config}")
    private String config;

    @GetMapping(value = "/get-config-info")
    public String getConfigInfo(){
        return config;
    }

}
