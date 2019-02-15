package com.laiyy.gitee.provider.springcloudproviderservicesimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProviderServiceSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderServiceSimpleApplication.class, args);
    }

}

