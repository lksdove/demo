package com.zzu.demo;

import com.alibaba.fastjson.JSON;
import com.zzu.demo.entity.User;
import com.zzu.demo.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test7() {
        Jedis jedis = new Jedis();
        jedis.auth("123456");
        log.info("连接redis成功");
        String name = jedis.get("name");
        User parseObject = JSON.parseObject(name, User.class);
        System.err.println(parseObject.toString());
        log.info("get成功");
    }

}
