package com.zzu.demo.exception;

import com.zzu.demo.result.ErrorResult;
import com.zzu.demo.result.WhhRestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理
 *
 * @author lks
 * @date 2020/11/19 11:04
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.zzu.demo.controller"})//返回json格式；还有@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    /**
     * 自定义全局的异常，当使用@RequestMapping的方法出现Exception异常，
     * 就会自动调用handleException方法，抛出自定义的提示信息给前端
     */
    @ExceptionHandler(value = Exception.class)//异常类型
    public ErrorResult handleException(Exception e) {
        final StringBuilder msg = new StringBuilder();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException) e;
            List<ObjectError> allErrors = argumentNotValidException.getBindingResult().getAllErrors();
            allErrors.forEach(error-> {
                msg.append("【");
                msg.append(error.getDefaultMessage());
                msg.append("】");
            });
        }else{
            msg.append(e.getLocalizedMessage());
        }
        log.error(msg.toString(), e);
        //返回错误实体，如果使用会在拦截器位置封装成返回结果体
        return new ErrorResult(400, msg.toString());
    }
}
