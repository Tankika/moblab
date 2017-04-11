package com.example.zizi.lab3.interactor.card.events;


import com.example.zizi.lab3.model.Card;

import java.util.List;

public class UpdateFavouriteCardEvent {
    private int code;
    private Card card;
    private Throwable throwable;

    public UpdateFavouriteCardEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
