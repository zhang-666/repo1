package com.qf.exception;

public class RException extends RuntimeException {
    private int code;
    private String msg;

    public RException() {
    }

    public RException(String msg) {
        this.msg = msg;
    }

    public RException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
