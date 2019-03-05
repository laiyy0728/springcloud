package com.laiyy.gitee.config.springcloudcustomerrepomysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudCustomerRepoMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCustomerRepoMysqlApplication.class, args);
    }

}
