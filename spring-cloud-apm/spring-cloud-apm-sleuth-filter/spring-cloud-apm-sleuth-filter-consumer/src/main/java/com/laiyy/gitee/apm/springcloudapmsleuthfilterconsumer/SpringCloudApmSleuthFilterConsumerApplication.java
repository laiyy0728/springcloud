package com.laiyy.gitee.apm.springcloudapmsleuthfilterconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudApmSleuthFilterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApmSleuthFilterConsumerApplication.class, args);
    }

}
