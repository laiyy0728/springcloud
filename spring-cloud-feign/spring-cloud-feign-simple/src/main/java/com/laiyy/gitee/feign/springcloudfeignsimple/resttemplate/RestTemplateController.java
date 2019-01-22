package com.laiyy.gitee.feign.springcloudfeignsimple.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author laiyy
 * @date 2019/1/22 15:39
 * @description
 */
@RestController
public class RestTemplateController {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "rest-get", produces = "text/html;charset=utf-8")
    public String restTemplateGet(){
        return restTemplate.getForObject("https://gitee.com", String.class);
    }

}
