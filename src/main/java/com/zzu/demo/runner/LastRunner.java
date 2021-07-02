package com.zzu.demo.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 项目启动提示信息，使用@Order注解
 */
@Order
@Slf4j
@Component
public class LastRunner implements ApplicationRunner {
    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context.isActive()) {
            log.info(" __    ___   _      ___   _     ____ _____  ____ ");
            log.info("/ /`  / / \\ | |\\/| | |_) | |   | |_   | |  | |_  ");
            log.info("\\_\\_, \\_\\_/ |_|  | |_|   |_|__ |_|__  |_|  |_|__ ");
            log.info("                                                      ");
            log.info("DEMO 启动完毕，时间：" + LocalDateTime.now());
        }
    }
}
