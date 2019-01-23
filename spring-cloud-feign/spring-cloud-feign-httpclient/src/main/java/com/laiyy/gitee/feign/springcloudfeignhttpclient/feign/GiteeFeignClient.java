package com.laiyy.gitee.feign.springcloudfeignhttpclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laiyy
 * @date 2019/1/22 16:35
 * @description
 */
@FeignClient(name = "gitee-client", url = "https://www.gitee.com/", configuration = GiteeFeignConfiguration.class)
public interface GiteeFeignClient {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String query);

}
