package com.laiyy.gitee.apm.springcloudapmsleuthfilterconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laiyy
 * @date 2019/4/12 16:14
 * description：
 */
@FeignClient(name = "spring-cloud-apm-sleuth-filter-provider", url = "localhost:8082")
public interface HelloService {

    @RequestMapping(value = "/say")
    String say(@RequestParam("name") String name);

}
