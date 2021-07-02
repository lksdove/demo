package com.zzu.demo.server;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class TestAsync {
    @Async
    public Future<Boolean> task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task1耗时：" + (end - start));
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> task2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("task2耗时：" + (end - start));
        return new AsyncResult<>(true);
    }
}
