package com.zzu.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lks
 * @date 2021/5/28 8:27
 * 在进行参数校验时，可以不使用javax.validation.Valid，@Valid只是一个标识，
 * spring会判断参数上是否有@Valid开头的注解，如果有就会进行参数检验
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidErp {

}
