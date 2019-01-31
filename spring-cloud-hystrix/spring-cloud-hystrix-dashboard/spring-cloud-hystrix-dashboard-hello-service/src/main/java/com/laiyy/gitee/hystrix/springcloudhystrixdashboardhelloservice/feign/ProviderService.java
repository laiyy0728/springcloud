package com.laiyy.gitee.hystrix.springcloudhystrixdashboardhelloservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author laiyy
 * @date 2019/1/31 16:23
 * @description
 */
@FeignClient(name = "spring-cloud-hystrix-dashboard-provider-service", fallback = ProviderServiceFallback.class)
public interface ProviderService {

    @RequestMapping(value = "/get-dashboard", method = RequestMethod.GET)
    List<String> getProviderData();

}
