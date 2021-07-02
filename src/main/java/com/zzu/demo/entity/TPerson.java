package com.zzu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 李康帅
 * @since 2020-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
public class TPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "姓名不能为空")//使用该实体时，该字段不能为空白
    private String name;

    private Integer age;


}
