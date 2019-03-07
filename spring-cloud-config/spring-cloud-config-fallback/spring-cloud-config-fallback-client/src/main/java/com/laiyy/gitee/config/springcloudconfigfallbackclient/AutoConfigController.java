package com.laiyy.gitee.config.springcloudconfigfallbackclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/3/6 15:07
 * @description
 */
@RestController
@RefreshScope
public class AutoConfigController {

    @Value("${com.laiyy.gitee.config}")
    private String config;

    @GetMapping(value = "/get-config-info")
    public String getConfigInfo(){
        return config;
    }

}
