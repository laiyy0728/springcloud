package com.laiyy.gitee.feign.springcloudfeignsimple.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author laiyy
 * @date 2019/1/22 15:40
 * @description
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
