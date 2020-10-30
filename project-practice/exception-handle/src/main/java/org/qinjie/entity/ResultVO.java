package org.qinjie.entity;

import lombok.Data;

/**
 * @author jieqin
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResultVO(){
        this(200, "success" , null);
    }

    public ResultVO(T data){
        this(200, "success" , data);
    }

    public ResultVO(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultVO(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = null;
    }

}
