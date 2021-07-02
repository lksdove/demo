package com.zzu.demo.filter;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<CountListener> countListenerServletRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new CountListener());
    }
}
