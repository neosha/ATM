package org.example.server.product;

public class Balance {
    private int sum;
    private String currency;

    public Balance(int sum, String currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public int getSum() {
        return sum;
    }
}
