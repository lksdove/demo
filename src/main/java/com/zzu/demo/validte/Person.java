package com.zzu.demo.validte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lks
 * @date 2020/12/10 13:02
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    @NotNull(message = "id不能为null！")
    private Integer id;

    private String name;

    private Integer age;
}
