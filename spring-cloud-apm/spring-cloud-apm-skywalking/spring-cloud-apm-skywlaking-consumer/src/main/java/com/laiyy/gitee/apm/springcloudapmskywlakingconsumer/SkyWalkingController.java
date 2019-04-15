package com.laiyy.gitee.apm.springcloudapmskywlakingconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/4/15 15:13
 * description：
 */
@RestController
public class SkyWalkingController {

    private final SkyWalkingFeignService feignService;

    @Autowired
    public SkyWalkingController(SkyWalkingFeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping(value = "/get-info")
    public String getInfo(){
        return feignService.getSendInfo("service");
    }

}
