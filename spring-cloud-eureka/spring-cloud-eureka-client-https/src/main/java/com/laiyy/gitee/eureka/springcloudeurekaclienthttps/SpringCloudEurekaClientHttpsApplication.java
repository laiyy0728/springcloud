package com.laiyy.gitee.eureka.springcloudeurekaclienthttps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaClientHttpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientHttpsApplication.class, args);
    }

}

