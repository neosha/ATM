package org.example.interaction;

public class ValidateException extends Exception{
    private int code;
    private String desc;

    public ValidateException(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ValidateException() {
        this.desc = "";
        this.code = 0;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
