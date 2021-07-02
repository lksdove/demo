package com.zzu.demo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lks
 * @date 2021/3/26 10:34
 */
@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class Test1 {
    private String port;
}
