package com.example.springdemo.domain;

import javax.validation.constraints.Min;

public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    @Min(value = 18)
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}
