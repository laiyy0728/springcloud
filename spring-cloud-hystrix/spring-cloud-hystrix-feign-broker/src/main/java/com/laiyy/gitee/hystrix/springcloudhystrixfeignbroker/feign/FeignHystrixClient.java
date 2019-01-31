package com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.feign;

import com.laiyy.gitee.hystrix.springcloudhystrixfeignbroker.feign.fallback.FeignHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laiyy
 * @date 2019/1/31 15:47
 * @description
 */
@FeignClient(name = "spring-cloud-ribbon-provider",fallback = FeignHystrixClientFallback.class)
public interface FeignHystrixClient {

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    String feignHystrix();

}
