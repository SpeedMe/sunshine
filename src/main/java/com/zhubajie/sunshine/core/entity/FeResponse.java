package com.zhubajie.sunshine.core.entity;

/**
 * FeResponse : 通用响应对象, 封装数据如下
 * @author huanglei
 */
public class FeResponse<T> {

    private Meta meta;

    private T data;

    public FeResponse() {

    }

    public FeResponse(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public FeResponse(Integer code, String message) {
        this.meta = new Meta(code, message);
        this.data = (T)new Object();
    }

    public FeResponse(Integer code, String message, T data) {
        this.meta = new Meta(code, message);
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
