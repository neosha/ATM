package org.example.server.product;

//import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Card {
    private ArrayList<Account> accounts = new ArrayList<>();

    private LocalDate expDate;
    private String number;
    private int PIN;

    public Account getAccount(int indx) throws AccountNotFoundException {
        if (accounts.size() <= indx) {
            throw new AccountNotFoundException(1, "Index out of range");
        }
        return accounts.get(indx);
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getNumber() {
        return number;
    }

    public int getPIN() {
        return PIN;
    }

    public Card(Account account, LocalDate expDate, String number, int PIN) {
        this.accounts.add(account);
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }

    public Optional<Account> getAccountOptional(int indx) {
        if (accounts.size() <= indx) {
            return Optional.empty();
        }
        return Optional.of(accounts.get(indx));
    }
}