package com.zzu.demo.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author lks
 * @date 2020/11/16 13:24
 */
public class ThreadPoolExecutorDemo {
    private final static Logger log= LoggerFactory.getLogger(ThreadPoolExecutorDemo.class);

    /**
     * 指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    /**
     * 当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁
     */
    private static int KEEP_ALIVE_TIME = 10;
    /**
     * keepAliveTime的单位
     */
    private static TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    /**
     * 任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种
     */
    private static BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    /**
     * 创建线程池
     */
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(NUMBER_OF_CORES,
            NUMBER_OF_CORES*2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQueue,
            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(
                i->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printStats(executorService);
                    executorService.submit(()->{
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
        );
    }

    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
            }, 0, 1, TimeUnit.SECONDS);
    }
}
