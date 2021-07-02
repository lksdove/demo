package com.zzu.demo.result;


import java.io.Serializable;

/**
 *
 * @author lks
 * @date 2020/11/18 16:20
 */
public class WhhRestResult<T> implements Serializable{


    private static final long serialVersionUID = -6047131911746534034L;
    /**
     * message_id
     */
    private String message_id;

    /**
     * 业务状态码
     */
    private int status;
    /**
     * 业务消息
     */
    private String message;
    /**
     * 业务响应数据
     */
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public WhhRestResult() {
    }
    public WhhRestResult(int status,String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public WhhRestResult(int status,String message) {
        this.status = status;
        this.message = message;
    }

    public static<T> WhhRestResult<T> status(int status) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(status);
        return restResult;
    }

    public static<T> WhhRestResult<T> status(int status, String message){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(status);
        restResult.setMessage(message);
        return restResult;
    }

    public static<T> WhhRestResult<T> status(RestResultStatus status){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(status.getStatus());
        restResult.setMessage(status.getMessage());
        return restResult;
    }

    public WhhRestResult<T> message(String message) {
        this.message = message;
        return this;
    }

    public WhhRestResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public WhhRestResult<T> data(RestResultStatus status,T data){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(status.getStatus());
        restResult.setMessage(status.getMessage());
        restResult.setData(data);
        return restResult;
    }

    public WhhRestResult<T> data(int status, String message,T data){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(status);
        restResult.setMessage(message);
        restResult.setData(data);
        return restResult;
    }

    public T data() {
        return this.data;
    }

    //快捷方法
    public static<T> WhhRestResult<T> ok() {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.OK.getStatus());
        restResult.setMessage(BaseStatus.OK.getMessage());
        return restResult;
    }

    public static<T> WhhRestResult<T> ok(Class<T> type) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.OK.getStatus());
        restResult.setMessage(BaseStatus.OK.getMessage());
        return restResult;
    }

    public static<T> WhhRestResult<T> ok(T data){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.OK.getStatus());
        restResult.setMessage(BaseStatus.OK.getMessage());
        restResult.setData(data);
        return restResult;
    }

    public static<T> WhhRestResult<T> server_error() {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.INTERNAL_SERVER_ERROR.getStatus());
        restResult.setMessage(BaseStatus.INTERNAL_SERVER_ERROR.getMessage());
        return restResult;
    }

    public static<T> WhhRestResult<T> server_error(Class<T> type) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.INTERNAL_SERVER_ERROR.getStatus());
        restResult.setMessage(BaseStatus.INTERNAL_SERVER_ERROR.getMessage());
        return restResult;
    }

    public static<T> WhhRestResult<T> server_error(String message){
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(BaseStatus.INTERNAL_SERVER_ERROR.getStatus());
        restResult.setMessage(message);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_found() {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.NOT_FOUND);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_found(Class<T> type) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.NOT_FOUND);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_found(String message) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.NOT_FOUND);
        restResult.setMessage(message);
        return restResult;
    }

    public static<T> WhhRestResult<T> forbidden() {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.FORBIDDEN);
        return restResult;
    }

    public static<T> WhhRestResult<T> forbidden(Class<T> type) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.FORBIDDEN);
        return restResult;
    }

    public static<T> WhhRestResult<T> forbidden(String message) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.FORBIDDEN);
        restResult.setMessage(message);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_acceptable() {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.Not_Acceptable);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_acceptable(Class<T> type) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.Not_Acceptable);
        return restResult;
    }

    public static<T> WhhRestResult<T> not_acceptable(String message) {
        WhhRestResult<T> restResult = new WhhRestResult<T>();
        restResult.setStatus(RestStatus.Not_Acceptable);
        restResult.setMessage(message);
        return restResult;
    }

    public WhhRestResult<T> messageId(String message_id) {
        this.message_id = message_id;
        return this;
    }

    public boolean isSuccess(){
        if(this.status==200){
            return true;
        }else{
            return false;
        }
    }

    public String getMessage_id() {
        return message_id;
    }
    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }
}
