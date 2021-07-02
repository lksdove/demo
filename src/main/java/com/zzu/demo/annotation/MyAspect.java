package com.zzu.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
@Order
public class MyAspect {
    @Pointcut("@annotation(com.zzu.demo.annotation.MyAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.info("注解切面调用1");
        Object proceed = point.proceed();
        log.info("proceed ==>" + proceed.toString());//proceed ==>User{id=1, name='lks', age=1}
        //获取使用注解的方法的参数
        Object[] args = point.getArgs();
        for (Object arg : args) {
            log.info("arg ==>" + arg);//arg ==>1
        }
        log.info("kind ==>" + point.getKind());//kind ==>method-execution
        //target ==>com.zzu.demo.controller.UserController@60be9864
        log.info("target ==>" + point.getTarget());
        //signature ==>User com.zzu.demo.controller.UserController.testAnnotation(String)
        log.info("signature ==>" + point.getSignature());

        //获取使用注解的值（属性）
        Object target = point.getTarget();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            String value = annotation.value();
            log.info("使用注解设置的值 ==>" + value);//使用注解设置的值 ==>lks
        }
        return proceed;
    }
}
