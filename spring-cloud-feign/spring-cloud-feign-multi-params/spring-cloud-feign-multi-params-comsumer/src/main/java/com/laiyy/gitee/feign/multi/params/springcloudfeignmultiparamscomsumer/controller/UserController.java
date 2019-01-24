package com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.controller;

import com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.feign.MultiParamsProviderFeignClient;
import com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/24 10:35
 * @description
 */
@RestController
public class UserController {

    private final MultiParamsProviderFeignClient feignClient;

    @Autowired
    public UserController(MultiParamsProviderFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @GetMapping(value = "add-user")
    public String addUser(User user){
        return feignClient.addUser(user);
    }

    @PostMapping(value = "update-user")
    public String updateUser(@RequestBody User user){
        return feignClient.updateUser(user);
    }

}
