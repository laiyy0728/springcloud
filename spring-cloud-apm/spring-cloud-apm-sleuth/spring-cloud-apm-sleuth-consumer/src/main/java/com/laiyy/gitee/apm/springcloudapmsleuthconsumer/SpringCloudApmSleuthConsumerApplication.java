package com.laiyy.gitee.apm.springcloudapmsleuthconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudApmSleuthConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApmSleuthConsumerApplication.class, args);
    }

}
