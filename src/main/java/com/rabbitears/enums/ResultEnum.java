package com.rabbitears.enums;

public enum ResultEnum {

    /**
     * 通用成功请求
     */
    SUCCESS(200, "请求成功"),
    /**
     * 通用失败请求
     */
    ERROR(500, "请求失败"),
    USER_INFO_EMPTY(10001, "用户名或密码不能为空"),
    USER_NAME_EXIST(10002, "用户名已存在"),
    USER_CONFIRM_PASSWORD_ERROR(10003, "密码输入不一致"),
    USER_INFO_ERROR(10004, "用户名或密码错误"),
    USER_PASSWORD_ERROR(10005, "密码输入错误")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
