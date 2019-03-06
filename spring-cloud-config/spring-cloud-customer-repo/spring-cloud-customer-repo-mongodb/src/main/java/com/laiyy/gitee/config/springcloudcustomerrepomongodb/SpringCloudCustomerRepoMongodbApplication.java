package com.laiyy.gitee.config.springcloudcustomerrepomongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.mongodb.EnableMongoConfigServer;

@SpringBootApplication
@EnableMongoConfigServer
public class SpringCloudCustomerRepoMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCustomerRepoMongodbApplication.class, args);
    }

}
