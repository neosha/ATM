package org.example.interaction;

import org.example.server.product.Balance;

import java.util.Optional;

public class Response {
    private Balance balance;
    private int code;
    private String desc;
//    private ValidateException validateException;



//    public ValidateException getValidateException() {
//        return validateException;
//    }

    public Optional<Balance> getBalance() {
        return Optional.ofNullable(balance);
    }

//    public Response(ValidateException validateException) {
//        this.balance = null;
//        this.validateException = validateException;
//    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public Response(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.balance = null;
    }

    public Response(Balance balance) {
        this.balance = balance;
        this.code =0;
        this.desc = "OK";
    }
}
