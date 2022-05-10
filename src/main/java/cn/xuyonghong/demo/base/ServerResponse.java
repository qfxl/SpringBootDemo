package cn.xuyonghong.demo.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;
    private Class<T> dataClazz;

    public ServerResponse() {
    }

    public ServerResponse(int status) {
        this.status = status;
    }

    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), "操作成功", data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse<T> createByError(String msg) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> ServerResponse<T> createByError(String msg, T data) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, data);
    }

    @JsonIgnore
    public Class<T> getDataClazz() {
        return this.dataClazz;
    }

    public void setDataClazz(Class<T> dataClazz) {
        this.dataClazz = dataClazz;
    }

}
