package com.zzu.demo.dao.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lks
 * @date 2021/3/26 10:24
 */
@Component
@ConfigurationProperties(prefix = "logging")
@Data
@ToString
public class Obj {
    private String config;
}
