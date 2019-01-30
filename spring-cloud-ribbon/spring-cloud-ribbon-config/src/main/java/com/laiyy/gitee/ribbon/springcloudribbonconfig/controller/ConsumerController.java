package com.laiyy.gitee.ribbon.springcloudribbonconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author laiyy
 * @date 2019/1/30 11:45
 * @description
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/check")
    public String checkRibbonProvider(){
        return restTemplate.getForObject("http://spring-cloud-ribbon-provider/check", String.class);
    }

}
