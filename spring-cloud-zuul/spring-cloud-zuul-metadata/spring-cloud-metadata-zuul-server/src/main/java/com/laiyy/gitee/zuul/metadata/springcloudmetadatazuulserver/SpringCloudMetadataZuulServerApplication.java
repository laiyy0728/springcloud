package com.laiyy.gitee.zuul.metadata.springcloudmetadatazuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringCloudMetadataZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMetadataZuulServerApplication.class, args);
    }

    @Bean
    public GrayFilter grayFilter(){
        return new GrayFilter();
    }

}
