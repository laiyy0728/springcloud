package com.laiyy.gitee.config.springcloudconfigfallbackserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigFallbackServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigFallbackServerApplication.class, args);
    }

}
