package com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudHystrixCacheProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixCacheProviderUserApplication.class, args);
    }

}

