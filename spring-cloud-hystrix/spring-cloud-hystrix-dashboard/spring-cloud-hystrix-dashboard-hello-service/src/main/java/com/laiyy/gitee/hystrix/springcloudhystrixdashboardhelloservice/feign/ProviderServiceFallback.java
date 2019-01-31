package com.laiyy.gitee.hystrix.springcloudhystrixdashboardhelloservice.feign;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiyy
 * @date 2019/1/31 17:56
 * @description
 */
@Component
public class ProviderServiceFallback implements ProviderService {
    @Override
    public List<String> getProviderData() {
        return new ArrayList<>();
    }
}
