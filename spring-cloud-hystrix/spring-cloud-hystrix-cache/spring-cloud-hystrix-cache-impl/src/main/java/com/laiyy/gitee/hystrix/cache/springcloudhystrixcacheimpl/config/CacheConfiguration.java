package com.laiyy.gitee.hystrix.cache.springcloudhystrixcacheimpl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author laiyy
 * @date 2019/2/11 14:15
 * @description
 */
@Configuration
public class CacheConfiguration {

    /**
     * 声明一个 cacheContextInterceptor 注入 Spring 容器
     */
    @Bean
    @ConditionalOnClass(Controller.class)
    public CacheContextInterceptor cacheContextInterceptor(){
        return new CacheContextInterceptor();
    }

    @Configuration
    @ConditionalOnClass(Controller.class)
    public class WebMvcConfig extends WebMvcConfigurationSupport{

        private final CacheContextInterceptor interceptor;

        @Autowired
        public WebMvcConfig(CacheContextInterceptor interceptor) {
            this.interceptor = interceptor;
        }

        /**
         * 将 cacheContextInterceptor 添加到拦截器中
         */
        @Override
        protected void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptor);
        }
    }

}
