package com.laiyy.gitee.ribbon.springcloudribbonprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/30 11:50
 * @description
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @GetMapping(value = "/check")
    public String providerPort(){
        return "Provider Port: " + port;
    }
}
