package com.laiyy.gitee.config.springcloudconfigbusserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigBusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigBusServerApplication.class, args);
    }

}
