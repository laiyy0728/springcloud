package com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamsprovider.controller;

import com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamsprovider.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiyy
 * @date 2019/1/24 10:42
 * @description
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/add")
    public String addUser(User user){
        return "hello!" + user.getName();
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestBody User user){
        return "hello! modifying " + user.getName();
    }

}
