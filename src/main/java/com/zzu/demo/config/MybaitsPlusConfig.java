package com.zzu.demo.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.zzu.demo.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zzu.demo.dao")
public class MybaitsPlusConfig {

    //mybaits-plus分页插件
    @Bean
    @ConditionalOnClass(User.class)
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
