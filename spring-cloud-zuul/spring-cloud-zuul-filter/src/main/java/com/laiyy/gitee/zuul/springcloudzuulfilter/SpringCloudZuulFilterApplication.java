package com.laiyy.gitee.zuul.springcloudzuulfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringCloudZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulFilterApplication.class, args);
    }

}

