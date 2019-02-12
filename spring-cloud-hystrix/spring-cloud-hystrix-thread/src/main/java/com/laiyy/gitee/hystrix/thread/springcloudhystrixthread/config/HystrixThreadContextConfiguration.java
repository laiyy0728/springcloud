package com.laiyy.gitee.hystrix.thread.springcloudhystrixthread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laiyy
 * @date 2019/2/12 15:26
 * @description
 */
@Configuration
public class HystrixThreadContextConfiguration {

    @Bean
    public SpringCloudHystrixConcurrencyStrategy springCloudHystrixConcurrencyStrategy(){
        return new SpringCloudHystrixConcurrencyStrategy();
    }

}
