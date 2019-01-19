package com.laiyy.gitee.eureka.springcloudeurekaserversimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author laiyy
 * @infomagtion 一个简单的 Eureka Server
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerSimpleApplication.class, args);
    }

}

