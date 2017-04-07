package com.example.zizi.lab3.interactor.card.events;


import com.example.zizi.lab3.model.Card;

import java.util.List;

public class GetCardsEvent {
    private int code;
    private List<Card> cards;
    private Throwable throwable;

    public GetCardsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
