package com.zzu.demo.entity;

/**
 * runnable的实例
 */
public class RunalbeTest implements Runnable {
    private ThreadLocal<String> local = new ThreadLocal<>();

    @Override
    public void run() {
        local.set(Math.random() + "");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        System.err.println("local:" + local.get());
    }
}
