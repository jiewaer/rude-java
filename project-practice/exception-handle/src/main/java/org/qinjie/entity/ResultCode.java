package org.qinjie.entity;

import lombok.Getter;

/**
 * @author jieqin
 */
@Getter
public enum ResultCode {

    /**
     * 正常结果
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 用户名密码错误
     */
    USERNAME_PASSWORD_ERROR(5001, "用户名密码错误"),
    /**
     * 校验异常
     */
    CHECK_EXCEPTION(5002, "校验异常"),
    /**
     * 字符串返回值处理异常
     */
    STRING_EXCEPTION(5003, "字符串返回值处理异常"),
    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
