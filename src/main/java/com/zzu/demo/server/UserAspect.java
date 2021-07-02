package com.zzu.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @author lks
 * @date 2021/5/11 16:11
 */
@Aspect
@Service
@Slf4j
public class UserAspect {
    @Before("execution(* com.zzu.demo.server.UserService.selectPerson(..))")
    public void testUser(JoinPoint joinPoint) {
        log.error("aop 测试用户service");
    }
}
