package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.controller;

import com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.model.Animal;
import com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.service.ICollapserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author laiyy
 * @date 2019/2/12 10:13
 * @description
 */
@RestController
public class CollapserController {

    private final ICollapserService collapserService;

    @Autowired
    public CollapserController(ICollapserService collapserService) {
        this.collapserService = collapserService;
    }

    @GetMapping("/get-animal")
    public String getAnimal() throws Exception{
        Future<Animal> animal = collapserService.collapsing(1);
        Future<Animal> animal2 = collapserService.collapsing(2);
        System.out.println(animal.get().getName());
        System.out.println(animal2.get().getName());
        return "success";
    }

    @GetMapping(value = "/get-animal-syn")
    public String getAnimalSyn() throws Exception{
        Animal animal1 = collapserService.collapsingSyn(1);
        Animal animal2 = collapserService.collapsingSyn(2);
        System.out.println(animal1.getName());
        System.out.println(animal2.getName());
        return "success";
    }

    @GetMapping(value = "/get-animal-global")
    public String getAnimalGlobal() throws Exception {
        Future<Animal> animal1 = collapserService.collapsingGlobal(1);
        Future<Animal> animal2 = collapserService.collapsingGlobal(2);
        System.out.println(animal1.get().getName());
        System.out.println(animal2.get().getName());
        return "success";
    }

}
