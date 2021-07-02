package com.zzu.demo.entity;

public class TryWithResource implements AutoCloseable {

    @Override
    public void close(){
        System.err.println("=======服务关闭========");
    }
}
