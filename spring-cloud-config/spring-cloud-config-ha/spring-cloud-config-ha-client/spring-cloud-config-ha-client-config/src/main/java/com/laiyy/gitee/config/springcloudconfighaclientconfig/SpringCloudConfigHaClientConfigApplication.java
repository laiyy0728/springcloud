package com.laiyy.gitee.config.springcloudconfighaclientconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConfigHaClientConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigHaClientConfigApplication.class, args);
    }

    @Value("${com.laiyy.gitee.config}")
    private String config;

    @GetMapping(value = "/config")
    public String getConfig(){
        return config;
    }

}
