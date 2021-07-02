package com.zzu.demo.annotation;

public class Person<T,V> {
    private V name;
    private T age;

    public void setAge(T age) {
        this.age = age;
    }

    public T getAge() {
        return age;
    }

    public void setName(V name) {
        this.name = name;
    }

    public V getName() {
        return name;
    }
}
