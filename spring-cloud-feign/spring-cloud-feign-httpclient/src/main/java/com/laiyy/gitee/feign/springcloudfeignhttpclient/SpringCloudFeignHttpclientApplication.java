package com.laiyy.gitee.feign.springcloudfeignhttpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignHttpclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignHttpclientApplication.class, args);
    }

}

