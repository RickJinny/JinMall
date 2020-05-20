package com.rick.jinmall.seckill.model;

/**
 * 通用状态码
 */
public enum StatusCode {

    SUCCESS(0,"成功"),
    FAIL(-1,"失败"),
    INVALID_PARAMS(201,"非法的参数!"),
    USER_NOT_LOGIN(202,"用户没登录"),

    ;

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
