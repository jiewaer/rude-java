package org.qinjie.exception;

import lombok.Data;
import org.qinjie.entity.ResultCode;

/**
 * @author jieqin
 */
@Data
public class ApiException extends RuntimeException {

    private Integer code;

    private String msg;

    private Object data;

    private ApiException(Integer code, String msg, Object data){
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ApiException(){
        this(200, "success", null);
    }

    private ApiException(String msg){
        this(500, msg, null);
    }

    public ApiException(ResultCode resultCode){
        this(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public ApiException(ResultCode resultCode, Object data){
        this(resultCode.getCode(), resultCode.getMsg(), data);
    }

}
