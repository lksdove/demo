package com.zzu.demo.entity;

import java.util.HashMap;

public class ResponseData extends HashMap<String, Object> {

    public ResponseData message(String code, String message) {
        this.put("code", code);
        this.put("message", message);
        return this;
    }

    public ResponseData data(Object data) {
        this.put("data", data);
        return this;
    }

    public ResponseData messageAndData(String message, Object data) {
        this.put("message", message);
        this.put("data", data);
        return this;
    }

    @Override
    public ResponseData put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
