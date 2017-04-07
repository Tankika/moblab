package com.example.zizi.lab3.repository;


import android.content.Context;

import com.example.zizi.lab3.model.Card;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {

    public static List<Card> cards;

    @Override
    public void open(Context context) {
        Card card1 = new Card(1L, "Azure Drake", 5, 4, 4, "Rotált :(", false),
                card2 = new Card(2L, "Ragnaros", 8, 8, 8, "Rotált :)", true);

        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
    }

    @Override
    public void close() {
        cards = null;
    }

    @Override
    public Card getCard(long cardId) {
        for (Card card : cards) {
            if(card.getId().equals(cardId)) {
                return card;
            }
        }

        return null;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void saveCard(Card card) {
        cards.add(card);
    }

    @Override
    public void updateCards(List<Card> cards) {
        for (int i = 0; i < this.cards.size(); i++) {
            Card storedCard = this.cards.get(i);
            for (Card card : cards) {
                if (card.getId().equals(storedCard.getId())) {
                    this.cards.set(i, card);
                }
            }
        }
    }

    @Override
    public void removeFavourite(Card card) {
        cards.remove(card);
    }

    @Override
    public boolean isInDB(Card card) {
        return cards.contains(card);
    }
}
