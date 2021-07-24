//package com.zzu.demo.redis;
//
//import com.alibaba.fastjson.JSON;
//import com.zzu.demo.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//
///**
// * @author lks
// * @date 2021/6/2 14:24
// */
//@Slf4j
//@RestController
//@RequestMapping("redis")
//public class RedisTest {
//
//    @PostMapping("setRedis")
//    public String setRedis() {
//        Jedis jedis = new Jedis();
//        jedis.auth("123456");
//        log.info("连接redis成功");
//        User user = new User();
//        user.setId(100);
//        user.setName("qwe");
//        user.setAge(200);
//        String userStr = JSON.toJSONString(user);
//        jedis.set("name", userStr);
//        log.info("set成功");
//        return "success";
//    }
//
//    @GetMapping("getRedis")
//    public String getRedis() {
//        Jedis jedis = new Jedis();
//        jedis.auth("123456");
//        log.info("连接redis成功");
//        String name = jedis.get("name");
//        User parseObject = JSON.parseObject(name, User.class);
//        System.err.println(parseObject.toString());
//        log.info("get成功");
//        return name;
//    }
//}
