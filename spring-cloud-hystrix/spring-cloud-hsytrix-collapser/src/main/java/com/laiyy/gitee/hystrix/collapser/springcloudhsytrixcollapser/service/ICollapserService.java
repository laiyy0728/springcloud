package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.service;

import com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.model.Animal;

import java.util.concurrent.Future;

/**
 * @author laiyy
 * @date 2019/2/12 9:55
 * @description
 */
public interface ICollapserService {

    Future<Animal> collapsing(Integer id);

    Animal collapsingSyn(Integer id);

    Future<Animal> collapsingGlobal(Integer id);

}
