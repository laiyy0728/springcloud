package com.laiyy.gitee.config.springcloudconfigjwtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigJwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigJwtServerApplication.class, args);
    }

}
