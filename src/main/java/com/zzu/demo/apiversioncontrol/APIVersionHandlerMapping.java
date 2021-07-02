package com.zzu.demo.apiversioncontrol;

import com.zzu.demo.exception.ParaException;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author lks
 * @date 2020/12/10 8:16
 */
public class APIVersionHandlerMapping extends RequestMappingHandlerMapping {
    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
    }

    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        Class<?> declaringClass = method.getDeclaringClass();
        //类上的APIVersion注解
        APIVersion typeAnnotation = AnnotationUtils.findAnnotation(declaringClass, APIVersion.class);
        //方法上的APIVersion注解
        APIVersion methodAnnotation = AnnotationUtils.findAnnotation(method, APIVersion.class);
        //以方法注解优先
        if (methodAnnotation != null) {
            typeAnnotation = methodAnnotation;
        }
        String[] urlPatterns = typeAnnotation == null ? new String[0] : typeAnnotation.value();
        PatternsRequestCondition apiPattern = new PatternsRequestCondition(urlPatterns);
        PatternsRequestCondition oldPattern = mapping.getPatternsCondition();
        PatternsRequestCondition updatedFinalPattern = apiPattern.combine(oldPattern);
        //重新构建RequestMappingInfo
        mapping = new RequestMappingInfo(mapping.getName(),updatedFinalPattern,mapping.getMethodsCondition(),
                mapping.getParamsCondition(),mapping.getHeadersCondition(),mapping.getConsumesCondition(),
                mapping.getProducesCondition(),mapping.getCustomCondition());
        super.registerHandlerMethod(handler, method, mapping);
    }
}
