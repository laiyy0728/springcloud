package com.laiyy.gitee.feign.springcloudfeignsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignSimpleApplication.class, args);
    }

}

