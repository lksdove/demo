package com.zzu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lks
 * @date 2021/5/28 13:30
 */
@SpringBootApplication
@MapperScan("com.zzu.demo.dao")
@ServletComponentScan
@EnableAsync
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    DemoApplication(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
//        String key = "mykey";
//        stringRedisTemplate.opsForValue().set(key, "myvalue");
//        Object valueGotFromStringRedisTemplate = stringRedisTemplate.opsForValue().get(key);
//        System.out.println(valueGotFromStringRedisTemplate);
//        Object valueGotFromRedisTemplate = redisTemplate.opsForValue().get(key);
//        System.out.println(valueGotFromRedisTemplate);
//    }

}
