package com.hc.system.admin.entity;

import com.hc.core.annotation.CheckEmail;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by milk.huchan on 2017/3/12.
 */
public class Person {

    @CheckEmail
    @Size(min=2, max=30)
    @NotNull(message = "{person.name.NotNull}")
    private String name;

    @NotNull(message = "{person.age.NotNull}")
    @Min(18)
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
