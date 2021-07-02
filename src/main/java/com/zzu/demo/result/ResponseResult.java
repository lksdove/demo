package com.zzu.demo.result;

import java.lang.annotation.*;

/**
 * @author lks
 * @date 2020-11-18$ 12:12:12$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
