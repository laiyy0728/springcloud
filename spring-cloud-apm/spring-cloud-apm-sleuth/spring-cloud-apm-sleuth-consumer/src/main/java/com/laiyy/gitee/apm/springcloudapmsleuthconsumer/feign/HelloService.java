package com.laiyy.gitee.apm.springcloudapmsleuthconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laiyy
 * @date 2019/4/11 16:35
 * description：
 */
@FeignClient(name = "spring-cloud-apm-sleuth-provider", url = "localhost:8082")
public interface HelloService {

    @RequestMapping(value = "/say")
    String sayHello(@RequestParam("name") String name);

}
