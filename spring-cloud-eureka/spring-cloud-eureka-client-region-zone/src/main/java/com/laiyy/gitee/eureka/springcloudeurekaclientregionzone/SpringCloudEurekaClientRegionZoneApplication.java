package com.laiyy.gitee.eureka.springcloudeurekaclientregionzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaClientRegionZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientRegionZoneApplication.class, args);
    }

}

