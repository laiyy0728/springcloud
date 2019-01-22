package com.laiyy.gitee.feign.springcloudfeignsimple.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/22 16:44
 * @description
 */
@RestController
public class FeignController {

    private final GiteeFeignClient giteeFeignClient;

    @Autowired
    public FeignController(GiteeFeignClient giteeFeignClient) {
        this.giteeFeignClient = giteeFeignClient;
    }

    @GetMapping(value = "feign-gitee")
    public String feign(String query){
        return giteeFeignClient.searchRepo(query);
    }

}
