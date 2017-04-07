package com.example.zizi.lab3.interactor.card.events;


import com.example.zizi.lab3.model.Card;

public class GetCardEvent {
    private int code;
    private Card card;
    private String initiatorMethod;
    private Throwable throwable;

    public GetCardEvent() {
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

    public String getInitiatorMethod() {
        return initiatorMethod;
    }

    public void setInitiatorMethod(String initiatorMethod) {
        this.initiatorMethod = initiatorMethod;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
