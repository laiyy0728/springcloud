package com.laiyy.gitee.hystrix.collapser.springcloudhsytrixcollapser.model;

import java.util.Objects;

/**
 * @author laiyy
 * @date 2019/2/12 9:53
 * @description
 */
public class Animal {

    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                Objects.equals(sex, animal.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public Animal(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
