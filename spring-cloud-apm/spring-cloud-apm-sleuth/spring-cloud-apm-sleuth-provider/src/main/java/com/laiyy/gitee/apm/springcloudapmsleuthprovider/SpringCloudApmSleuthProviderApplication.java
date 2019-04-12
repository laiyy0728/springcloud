package com.laiyy.gitee.apm.springcloudapmsleuthprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudApmSleuthProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApmSleuthProviderApplication.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudApmSleuthProviderApplication.class);

    @GetMapping(value = "/say")
    public String hello(String name){
        LOGGER.info(">>>>>>>>>>>>>>>>>>> 接收到参数：{}<<<<<<<<<<<<<<<<<<<<", name);
        String result = "你好啊~" + name;
        LOGGER.info(">>>>>>>>>>>>>>>>>>> 返回值：{} <<<<<<<<<<<<<<<<<<<<<<", result);
        return result;
    }

}
