package com.laiyy.gitee.zuul.ratelimit.springcloudratelimitproviderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudRatelimitProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRatelimitProviderServiceApplication.class, args);
    }

}
