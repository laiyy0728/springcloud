package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.service;

import com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.model.Animal;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author laiyy
 * @date 2019/2/12 9:57
 * @description
 */
@Component
public class CollpaserServiceImpl implements ICollapserService {

    @Override
    @HystrixCollapser(batchMethod = "collapsingList", collapserProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS, value = "1000")
    })
    public Future<Animal> collapsing(Integer id) {
        return null;
    }

    @Override
    @HystrixCollapser(batchMethod = "collapsingList", collapserProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS, value = "1000")
    })
    public Animal collapsingSyn(Integer id) {
        return null;
    }

    @Override
    @HystrixCollapser(batchMethod = "collapsingListGlobal",
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS, value = "10000")
            })
    public Future<Animal> collapsingGlobal(Integer id) {
        return null;
    }

    @HystrixCommand
    public List<Animal> collapsingList(List<Integer> animalParam) {
        System.out.println("collapsingList 当前线程：" + Thread.currentThread().getName());
        System.out.println("当前请求参数个数：" + animalParam.size());
        List<Animal> animalList = Lists.newArrayList();
        animalParam.forEach(num -> {
            Animal animal = new Animal();
            animal.setName(" Cat - " + num);
            animal.setAge(num);
            animal.setSex("male");
            animalList.add(animal);
        });
        return animalList;
    }

    @HystrixCommand
    public List<Animal> collapsingListGlobal(List<Integer> animalParam) {
        System.out.println("collapsingListGlobal 当前线程：" + Thread.currentThread().getName());
        System.out.println("当前请求参数个数：" + animalParam.size());
        List<Animal> animalList = Lists.newArrayList();
        animalParam.forEach(num -> {
            Animal animal = new Animal();
            animal.setName(" Dog - " + num);
            animal.setAge(num);
            animal.setSex("female");
            animalList.add(animal);
        });
        return animalList;
    }

}
