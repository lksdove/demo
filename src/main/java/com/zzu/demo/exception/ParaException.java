package com.zzu.demo.exception;

import com.zzu.demo.entity.SexEnum;

public class ParaException extends RuntimeException {
    private String code;

    public ParaException() {
    }

    public ParaException(SexEnum message) {
        super(message.getSex());
    }

    public ParaException(String message) {
        super(message);
    }
}
