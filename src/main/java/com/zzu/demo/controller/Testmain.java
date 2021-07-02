package com.zzu.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lks
 * @date 2020/11/20 10:09
 */
@Slf4j
public class Testmain {
    private static final Map<Class<?>, Object> DEFAULT_VALUES = Stream
            .of(boolean.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
            .collect(Collectors.toMap(clazz -> (Class<?>) clazz, clazz -> Array.get(Array.newInstance(clazz, 1), 0)));

    public static <T> T getDefaultValue(Class<T> clazz) {
        return (T) DEFAULT_VALUES.get(clazz);
    }

    public static void main(String[] args) throws IOException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/hi");
        builder.queryParam("para1", "开发测试 001");
        String url = builder.toUriString();
        Map m=new HashMap();
        m.put("k1",Arrays.asList("123"));
        Object k1 = m.computeIfAbsent("k1", k -> new ArrayList<>());

    }
}
