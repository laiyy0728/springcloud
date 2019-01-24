package com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.feign;

import com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laiyy
 * @date 2019/1/24 10:29
 * @description
 */
@FeignClient(name = "spring-cloud-feign-multi-params-provider")
public interface MultiParamsProviderFeignClient {

    /**
     * GET 方式
     * @param user user
     * @return 添加结果
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    String addUser(User user);

    /**
     * POST 方式
     * @param user user
     * @return 修改结果
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    String updateUser(@RequestBody User user);


}
