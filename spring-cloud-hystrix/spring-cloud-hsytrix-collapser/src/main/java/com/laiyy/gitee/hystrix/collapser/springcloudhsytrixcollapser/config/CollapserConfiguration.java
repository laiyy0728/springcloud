package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author laiyy
 * @date 2019/2/12 10:11
 * @description
 */
@Configuration
public class CollapserConfiguration {


    @Bean
    @ConditionalOnClass(Controller.class)
    public HystrixCollapserInterceptor hystrixCollapserInterceptor(){
        return new HystrixCollapserInterceptor();
    }

    @Configuration
    @ConditionalOnClass(Controller.class)
    public class WebMvcConfig extends WebMvcConfigurationSupport{
        private final HystrixCollapserInterceptor interceptor;

        @Autowired
        public WebMvcConfig(HystrixCollapserInterceptor interceptor) {
            this.interceptor = interceptor;
        }

        @Override
        protected void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptor);
        }
    }

}
