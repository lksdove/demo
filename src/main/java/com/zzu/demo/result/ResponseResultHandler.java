package com.zzu.demo.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 3、处理拦截器修饰的请求
 *
 * @author lks
 * @date 2020/11/19 8:34
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    private static final String MSG = "RESPONSE_REST";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //判断请求是否有包装标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(MSG);
        return responseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        try {
            log.info("包装返回实体开始=============="+o.toString());
            if(o instanceof ErrorResult){
                ErrorResult errorResult = (ErrorResult)o;
                return WhhRestResult.server_error(errorResult.getMsg());
            }
            return WhhRestResult.ok(o);
        }finally {
            log.info("包装返回实体结束=============="+o.toString());
        }
    }
}
