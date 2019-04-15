package com.laiyy.gitee.apm.springcloudapmskywalkingprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudApmSkywalkingProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApmSkywalkingProviderApplication.class, args);
    }

    @GetMapping(value = "/get-send-info")
    public String getSendInfo(@RequestParam("serviceName") String serviceName){
        return serviceName + " --> " + "spring-cloud-apm-skywalking-provider";
    }

}
