package com.sxt.base.common;
/**
 * @author jl
 */
public class RestfulResponseStatus {
    public static final String NO_DATA_FOUND = "找不到数据";
    private boolean success;
    private String msg;

    public RestfulResponseStatus() {
        this.success = false;
        this.msg = "";
    }

    public RestfulResponseStatus(boolean success, String msg) {
        this.success = success;
        if(null == msg) {
            this.msg = "";
        } else {
            this.msg = msg;
        }

    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
