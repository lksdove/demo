package com.zzu.demo.entity;

import jdk.nashorn.internal.runtime.options.Option;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * @author lks
 * @date 2020/11/20 15:28
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4488436994348008601L;
    
    private int id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @Min(value = 1, message = "年龄最小为1")
    @Max(value = 150, message = "年龄最大150")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
