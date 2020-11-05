package com.rocketmq.entity;

import lombok.Data;

/**
 * @author jieqin
 */
@Data
public class ServerResponse {

    private int code;
    private String msg;
    private Object data;

    ServerResponse(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ServerResponse success(){
        return new ServerResponse(200, "success", null);
    }

}