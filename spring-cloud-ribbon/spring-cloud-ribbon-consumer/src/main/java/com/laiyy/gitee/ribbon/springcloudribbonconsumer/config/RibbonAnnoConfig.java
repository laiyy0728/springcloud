//package com.laiyy.gitee.ribbon.springcloudribbonconsumer.config;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author laiyy
// * @date 2019/1/30 14:22
// * @description
// */
//@Configuration
//@RibbonAnnotation
//public class RibbonAnnoConfig {
//
//    private final IClientConfig clientConfig;
//
//    @Autowired(required = false)
//    public RibbonAnnoConfig(IClientConfig clientConfig) {
//        this.clientConfig = clientConfig;
//    }
//
//    @Bean
//    public IRule ribbonRule(IClientConfig clientConfig){
//        return new RandomRule();
//    }
//}
