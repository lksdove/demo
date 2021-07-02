package com.zzu.demo.result;

/**
 *
 * @author lks
 * @date 2020/11/18 16:20
 */
public class BaseStatus implements RestResultStatus {

    public static final BaseStatus OK = new BaseStatus(RestStatus.OK,"处理成功");
    public static final BaseStatus INTERNAL_SERVER_ERROR = new BaseStatus(RestStatus.INTERNAL_SERVER_ERROR,"服务器繁忙");

    private int status;
    private String message;

    public BaseStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
