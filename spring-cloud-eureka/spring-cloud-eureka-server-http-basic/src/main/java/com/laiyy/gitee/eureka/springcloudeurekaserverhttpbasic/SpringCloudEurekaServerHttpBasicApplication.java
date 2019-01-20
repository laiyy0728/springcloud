package com.laiyy.gitee.eureka.springcloudeurekaserverhttpbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerHttpBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerHttpBasicApplication.class, args);
    }

}

