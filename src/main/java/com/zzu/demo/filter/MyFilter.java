package com.zzu.demo.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = {"/*"})
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.error("自定义过滤器启动啦！！！！！！！！！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        log.error("开始计算接口:[{}]耗时", requestURL.toString());
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        log.error("执行时间(ms)：" + time);
    }

    @Override
    public void destroy() {
        log.error("MyFilter destroy");
    }
}
