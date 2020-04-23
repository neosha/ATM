package org.example.server;

import org.example.interaction.Response;
import org.example.interaction.Request;
import org.example.interaction.ValidateException;
import org.example.server.product.Card;

public class Host {
    private Card card;

    public Host(Card card) {
        this.card = card;
    }

    public Response getBalance(Request request){
        Response response;
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Response(e.getCode(),e.getDesc());
        }
        return new Response(card.getAccount().getBalance());
    }

    private void validate(Request request) throws ValidateException {
        if(card.getNumber() != request.getNumber()){
             throw new ValidateException(3,"Error3");
        }
        if (card.getPIN() != request.getPIN()) {
            throw  new ValidateException(1,"Error2");
        }
        if(!card.getExpDate().equals(request.getExpDate())){
            throw new ValidateException(2,"Error1");
        }


    }
}