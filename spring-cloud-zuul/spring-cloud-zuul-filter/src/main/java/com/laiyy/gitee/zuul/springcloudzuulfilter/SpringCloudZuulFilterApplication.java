package com.laiyy.gitee.zuul.springcloudzuulfilter;

import com.laiyy.gitee.zuul.springcloudzuulfilter.filter.FirstPreFilter;
import com.laiyy.gitee.zuul.springcloudzuulfilter.filter.PostFilter;
import com.laiyy.gitee.zuul.springcloudzuulfilter.filter.SecondPreFilter;
import com.laiyy.gitee.zuul.springcloudzuulfilter.filter.ThirdPreFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringCloudZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulFilterApplication.class, args);
    }

    @Bean
    public FirstPreFilter firstPreFilter(){
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter(){
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter(){
        return new ThirdPreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
}

