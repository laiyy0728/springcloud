package com.laiyy.gitee.config.springcloudconfigfallbackautorefresh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@EnableConfigurationProperties
@PropertySource(value = {"configClient.properties", "file:${spring.cloud.config.fallbackLocation:}/fallback.properties"}, ignoreResourceNotFound = true)
public class ConfigServerBootStrap {

    public static final String FALLBACK_NAME = "fallback.properties";

    private final ConfigurableEnvironment configurableEnvironment;

    private final ConfigClientProperties configClientProperties;


    @Autowired
    public ConfigServerBootStrap(ConfigurableEnvironment configurableEnvironment, ConfigClientProperties configClientProperties) {
        this.configurableEnvironment = configurableEnvironment;
        this.configClientProperties = configClientProperties;

        this.configClientProperties.setEnabled(false);
    }

    @Value("${spring.cloud.config.fallbackLocation:}")
    private String fallbackLocation;

//    @Bean(name = "clientProperties")
//    public ConfigClientProperties configClientProperties() {
//        ConfigClientProperties configClientProperties = new ConfigClientProperties(this.configurableEnvironment);
//        configClientProperties.setEnabled(false);
//        return configClientProperties;
//    }

    @Bean
    public FallbackableConfigServerPropertySourceLocator fallbackableConfigServerPropertySourceLocator() {

        return new FallbackableConfigServerPropertySourceLocator(configClientProperties, fallbackLocation);
    }


}

