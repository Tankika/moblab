package com.example.zizi.lab3.repository;


import android.content.Context;

import com.example.zizi.lab3.model.Card;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public Card getCard(long cardId) {
        return SugarRecord.findById(Card.class, cardId);
    }

    @Override
    public List<Card> getCards() {
        return SugarRecord.listAll(Card.class);
    }

    @Override
    public void saveCard(Card card) {
        SugarRecord.saveInTx(card);
    }

    @Override
    public void updateCards(List<Card> cards) {
        List<Card> storedCards = getCards();
        List<Card> toUpdate = new ArrayList<>(storedCards.size());
        for (Card favourite : storedCards) {
            for (Card card : cards) {
                if (card.getId().equals(favourite.getId())) {
                    toUpdate.add(card);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeFavourite(Card card) {
        SugarRecord.deleteInTx(card);
    }

    @Override
    public boolean isInDB(Card card) {
        return SugarRecord.findById(Card.class, card.getId()) != null;
    }
}
