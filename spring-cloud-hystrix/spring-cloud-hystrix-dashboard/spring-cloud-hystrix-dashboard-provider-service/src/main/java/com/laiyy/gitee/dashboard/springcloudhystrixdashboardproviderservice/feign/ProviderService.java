package com.laiyy.gitee.dashboard.springcloudhystrixdashboardproviderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laiyy
 * @date 2019/1/31 16:45
 * @description
 */
@FeignClient(name = "spring-cloud-hystrix-dashboard-hello-service")
public interface ProviderService {

    @RequestMapping(value = "/hello-service", method = RequestMethod.GET)
    String helloService();

}
