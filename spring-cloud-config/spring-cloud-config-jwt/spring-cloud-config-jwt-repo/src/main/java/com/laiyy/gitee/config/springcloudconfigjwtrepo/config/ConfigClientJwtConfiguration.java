package com.laiyy.gitee.config.springcloudconfigjwtrepo.config;

import com.laiyy.gitee.config.springcloudconfigjwtrepo.dto.LoginRequest;
import com.laiyy.gitee.config.springcloudconfigjwtrepo.dto.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/3/7 10:54
 * @description
 */
@Configuration
@Order
public class ConfigClientJwtConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigClientJwtConfiguration.class);

    @Value("${spring.cloud.config.username}")
    private String jwtUsername;

    @Value("${spring.cloud.config.password}")
    private String jwtPassword;

    @Value("${spring.cloud.config.endpoint}")
    private String jwtEndpoint;

    private String jwtToken;

    private final ConfigurableEnvironment configurableEnvironment;

    private final ConfigClientProperties configClientProperties;

    @Autowired
    public ConfigClientJwtConfiguration(ConfigurableEnvironment configurableEnvironment, ConfigClientProperties configClientProperties) {
        this.configurableEnvironment = configurableEnvironment;
        configClientProperties.setEnabled(false);
        this.configClientProperties = configClientProperties;
    }

    @Bean
    public ConfigServicePropertySourceLocator configServicePropertySourceLocator(){
        ConfigServicePropertySourceLocator configServicePropertySourceLocator = new ConfigServicePropertySourceLocator(configClientProperties);
        configServicePropertySourceLocator.setRestTemplate(restTemplate());
        return configServicePropertySourceLocator;
    }


    private RestTemplate restTemplate(){
        Map<String, String> headers = new HashMap<>();
        headers.put("token", "Bearer:" + jwtToken);
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(60 * 1000 * 3 + 5000);
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        if (!headers.isEmpty()) {
            restTemplate.setInterceptors(Collections.singletonList(new GenericRequestHeaderInterceptor(headers)));
        }
        return restTemplate;
    }


    public static class GenericRequestHeaderInterceptor implements ClientHttpRequestInterceptor{

        private final Map<String, String> headers;

        public GenericRequestHeaderInterceptor(Map<String, String> headers) {
            this.headers = headers;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
            headers.entrySet().stream().forEach( header -> {
                httpRequest.getHeaders().add(header.getKey(), header.getValue());
            });
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        }
    }


    /**
     * 初始化时设置 token（简单示例）
     */
    @PostConstruct
    public void init(){
        RestTemplate restTemplate = new RestTemplate();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(jwtUsername);
        loginRequest.setPassword(jwtPassword);

        String serviceUrl = jwtEndpoint;
        Token token;
        try {
            token = restTemplate.postForObject(serviceUrl, loginRequest, Token.class);
            if (token == null || StringUtils.isEmpty(token.getToken())){
                throw new Exception();
            }

            // 设置 token
            setJwtToken(token.getToken());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
