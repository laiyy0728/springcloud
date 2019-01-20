package com.laiyy.gitee.eureka.springcloudeurekaserverregionzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerRegionZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerRegionZoneApplication.class, args);
    }

}

