package org.example.interaction;

import java.time.LocalDate;

public class Request {
    private LocalDate expDate;
    private String number;
    private int PIN;

    public int getPIN() {
        return PIN;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public Request(LocalDate expDate, String number, int PIN) {
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }
}
