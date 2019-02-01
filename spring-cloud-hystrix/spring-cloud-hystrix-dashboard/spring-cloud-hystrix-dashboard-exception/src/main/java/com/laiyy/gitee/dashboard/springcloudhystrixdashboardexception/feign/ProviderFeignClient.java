package com.laiyy.gitee.dashboard.springcloudhystrixdashboardexception.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laiyy
 * @date 2019/2/1 11:48
 * @description
 */
@FeignClient("spring-cloud-hystrix-dashboard-provider-service")
public interface ProviderFeignClient {

    @RequestMapping(value = "/bad-request", method = RequestMethod.GET)
    String badRequest(@RequestParam String name);

}
