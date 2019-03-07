package com.laiyy.gitee.config.springcloudconfigfallbackautorefresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * @author laiyy
 * @date 2019/3/6 16:39
 * @description
 */
@Order(0)
public class FallbackableConfigServerPropertySourceLocator extends ConfigServicePropertySourceLocator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackableConfigServerPropertySourceLocator.class);

    private boolean fallbackEnabled;

    private String fallbackLocation;

    @Autowired(required = false)
    private TextEncryptor textEncryptor;

    public FallbackableConfigServerPropertySourceLocator(ConfigClientProperties defaultProperties, String fallbackLocation) {
        super(defaultProperties);
        this.fallbackLocation = fallbackLocation;
        this.fallbackEnabled = !StringUtils.isEmpty(fallbackLocation);
    }

    @Override
    public PropertySource<?> locate(Environment environment) {
        PropertySource<?> propertySource = super.locate(environment);
        if (fallbackEnabled && propertySource != null) {
            storeLocally(propertySource);
        }
        return propertySource;
    }

    /**
     * 转换配置文件
     */
    private void storeLocally(PropertySource propertySource) {
        StringBuilder builder = new StringBuilder();
        CompositePropertySource source = (CompositePropertySource) propertySource;
        for (String propertyName : source.getPropertyNames()) {
            Object property = source.getProperty(propertyName);
            if (textEncryptor != null) {
                property = "{cipher}" + textEncryptor.encrypt(String.valueOf(property));
            }
            builder.append(propertyName).append("=").append(property).append("\n");
        }
        LOGGER.info(">>>>>>>>>>>>>>>>> file content: {} <<<<<<<<<<<<<<<<<<<", builder);
        saveFile(builder.toString());
    }

    /**
     * 保存配置到本地
     *
     * @param content 配置内容
     */
    private void saveFile(String content) {
        File file = new File(fallbackLocation + File.separator + ConfigServerBootStrap.FALLBACK_NAME);
        try {
            FileCopyUtils.copy(content.getBytes(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
