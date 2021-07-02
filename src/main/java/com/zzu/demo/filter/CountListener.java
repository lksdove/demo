package com.zzu.demo.filter;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CountListener implements HttpSessionListener {
    private Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        se.getSession().getServletContext().setAttribute("count", count);
        System.err.println("新增在线人数，当前在线人数" + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        se.getSession().getServletContext().setAttribute("count", count);
        System.err.println("删减在线人数，当前在线人数" + count);
    }
}
