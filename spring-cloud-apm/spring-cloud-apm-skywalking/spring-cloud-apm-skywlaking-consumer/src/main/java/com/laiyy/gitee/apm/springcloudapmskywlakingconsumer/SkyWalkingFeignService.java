package com.laiyy.gitee.apm.springcloudapmskywlakingconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laiyy
 * @date 2019/4/15 15:12
 * description：
 */
@FeignClient("spring-cloud-apm-skywalking-provider")
public interface SkyWalkingFeignService {

    @RequestMapping(value = "/get-send-info", method = RequestMethod.GET)
    String getSendInfo(@RequestParam("serviceName") String serviceName);

}
