package com.laiyy.gitee.feign.springcloudfeigngzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignGzipApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignGzipApplication.class, args);
    }

}

