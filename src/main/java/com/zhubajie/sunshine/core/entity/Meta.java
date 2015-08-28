package com.zhubajie.sunshine.core.entity;

/**
 * Meta : 封装返回给前端的metadata
 *
 * @author huanglei
 */
public class Meta {

    private Integer code;

    private String message;

    public Meta() {
    }

    public Meta(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
