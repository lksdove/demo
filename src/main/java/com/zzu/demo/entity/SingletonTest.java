package com.zzu.demo.entity;

/**
 * @Author: likangshuai
 * @Date: 2020/7/18 10:17
 * @Describe
 * @Since V1.0
 */
public class SingletonTest {

    static String s = "lks";

    {
        System.err.println("代码构造块");
    }

    static {
        System.err.println("静态代码块");
    }

    static void methodStatic() {
        System.err.println("静态方法");
    }

    public SingletonTest() {
        System.err.println("构造方法");
    }

    public static void main(String[] args) {
        SingletonTest s = new SingletonTest();
        System.err.println("main函数");
    }
}
