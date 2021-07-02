package com.zzu.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lks
 * @date 2020/11/19 8:51
 */
@Data
@AllArgsConstructor
public class ErrorResult implements Serializable {
    private Integer code;
    private String msg;
}
