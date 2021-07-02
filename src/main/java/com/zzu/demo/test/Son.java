package com.zzu.demo.test;

import cn.hutool.core.util.IdUtil;

public class Son implements Parent {

    @Override
    public void add(int a1, int a2) {
        String simpleUUID = IdUtil.simpleUUID();
        System.err.println(simpleUUID);
    }

    public void showAge(Integer age) {
        System.err.println(age);
    }
}
