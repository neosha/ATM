package org.example.server;

import org.example.interaction.Response;
import org.example.interaction.Request;
import org.example.interaction.ValidateException;
import org.example.server.product.Account;
import org.example.server.product.AccountNotFoundException;
import org.example.server.product.AccountTypes;
import org.example.server.product.Card;

import java.util.Map;
import java.util.TreeMap;

public class Host {
    private Map<String,Card> cards = new TreeMap<>();

    public Host(Card cards) {
        this.cards.put(cards.getNumber(), cards);
    }

    public Response getBalance(Request request){
        Response response;
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Response(e.getCode(),e.getDesc());
        }
//        return Optional.ofNullable(cards.get(request.getNumber()));
        Account account;
        try{
            account = cards.get(request.getNumber()).getAccount(AccountTypes.DEFAULT.ordinal());
            return new Response(account.getBalance());
        }
        catch (AccountNotFoundException e){
            e.printStackTrace();
            return new Response(e.getCode(), e.getDesc());
        }
    }

    private void validate(Request request) throws ValidateException {

        if (!cards.containsKey(request.getNumber())) {
            throw new ValidateException(3, "Error3");
        }
        Card card = cards.get(request.getNumber());
        if (card.getPIN() != request.getPIN()) {
            throw new ValidateException(1, "Error2");
        }
        if (!card.getExpDate().equals(request.getExpDate())) {
            throw new ValidateException(2, "Error1");
        }
    }

    @Override
    public String toString() {
        String result = "Cards TreeMap size: " + cards.size() + ".\n";
        //todo: написать алгоритм форматирования строки
        for(Map.Entry<String,Card> item:cards.entrySet()) {
            result += "CardNumber:" + item.getValue().getNumber() +
                    "Card ExpDate: " + item.getValue().getExpDate() +
                    "Card Pin: " + item.getValue().getPIN() + "\n";
        }
        return result;
    }
}