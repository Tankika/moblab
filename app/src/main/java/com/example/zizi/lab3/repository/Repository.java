package com.example.zizi.lab3.repository;

import android.content.Context;

import com.example.zizi.lab3.model.Card;

import java.util.List;

public interface Repository {

    void open(Context context);

    void close();

    Card getCard(long cardId);

    List<Card> getCards();

    void saveCard(Card card);

    void updateCards(List<Card> cards);

    void removeFavourite(Card card);

    boolean isInDB(Card card);
}
