package com.laiyy.gitee.feign.file.springcloudfeignfileclient.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author laiyy
 * @date 2019/1/25 10:15
 * @description Feign 文件上传 Client 配置
 */
@Configuration
public class FeignMultipartConfiguration {

    /**
     * Feign Spring 表单编码器
     * @return 表单编码器
     */
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartEncoder(){
        return new SpringFormEncoder();
    }

}
