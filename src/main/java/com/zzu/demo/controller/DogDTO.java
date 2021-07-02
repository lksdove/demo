package com.zzu.demo.controller;

import com.zzu.demo.dao.UserDao;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author lks
 * @date 2021/2/23 13:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DogDTO implements Serializable {
    private static final long serialVersionUID = 6810563099894026020L;
    @NotNull(message = "姓名不能为空")
    @Size(min = 1,max = 10)
    public String name;

    @Min(value = 18)
    @Max(value = 150)
    private Integer age;
    @NotEmpty(message = "描述不能为空白")
    private String des;
    @Email(message = "必须为邮箱格式")
    private String email;

    private Optional<String> sex;
}
