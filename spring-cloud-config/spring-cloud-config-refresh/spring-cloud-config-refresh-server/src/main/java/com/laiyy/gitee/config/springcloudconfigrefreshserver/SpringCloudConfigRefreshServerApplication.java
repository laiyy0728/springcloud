package com.laiyy.gitee.config.springcloudconfigrefreshserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigRefreshServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigRefreshServerApplication.class, args);
    }

}
