package com.laiyy.gitee.eureka.springcloudeurekaclientsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author laiyy
 * @infomation 一个简单的 Eureka Client
 */
@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient
public class SpringCloudEurekaClientSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientSimpleApplication.class, args);
    }

}

