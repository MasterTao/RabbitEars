package com.rabbitears.entity;

import com.rabbitears.enums.ResultEnum;
import lombok.Data;

@Data
public class Result {

    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result build(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result build(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result buildSuccess() {
        return build(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }
}
