package com.zzu.demo.entity;

/**
 * @Author: likangshuai
 * @Date: 2020/8/21 13:16
 * @Describe
 * @Since V1.0
 */
public abstract class Bridge {
    private String name;

    public void method(){
        System.err.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
