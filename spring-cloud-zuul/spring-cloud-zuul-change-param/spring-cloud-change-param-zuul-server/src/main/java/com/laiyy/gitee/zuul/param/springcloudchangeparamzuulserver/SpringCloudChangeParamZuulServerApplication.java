package com.laiyy.gitee.zuul.param.springcloudchangeparamzuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringCloudChangeParamZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudChangeParamZuulServerApplication.class, args);
    }

}
