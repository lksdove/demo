package com.zzu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Integer version;
    private String flag;
    private Optional<String> option;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
