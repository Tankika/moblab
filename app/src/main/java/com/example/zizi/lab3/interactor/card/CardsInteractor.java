package com.example.zizi.lab3.interactor.card;


import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.MobSoftApplicationComponent;
import com.example.zizi.lab3.interactor.card.events.GetCardEvent;
import com.example.zizi.lab3.interactor.card.events.GetCardsEvent;
import com.example.zizi.lab3.interactor.card.events.RemoveCardEvent;
import com.example.zizi.lab3.interactor.card.events.SaveCardEvent;
import com.example.zizi.lab3.interactor.card.events.UpdateCardsEvent;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class CardsInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public CardsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCard(long cardId, String initiatorMethod) {
        GetCardEvent event = new GetCardEvent();
        event.setInitiatorMethod(initiatorMethod);
        try {
            Card card = repository.getCard(cardId);
            event.setCard(card);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getCards() {
        GetCardsEvent event = new GetCardsEvent();
        try {
            List<Card> cards = repository.getCards();
            event.setCards(cards);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveCard(Card card) {
        SaveCardEvent event = new SaveCardEvent();
        event.setCard(card);
        try {
            repository.saveCard(card);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateCards(List<Card> cards) {
        UpdateCardsEvent event = new UpdateCardsEvent();
        event.setCards(cards);
        try {
            repository.updateCards(cards);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removeCard(Card card) {
        RemoveCardEvent event = new RemoveCardEvent();
        event.setCard(card);
        try {
            repository.removeFavourite(card);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
