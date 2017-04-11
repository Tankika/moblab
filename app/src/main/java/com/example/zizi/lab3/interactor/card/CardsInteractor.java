package com.example.zizi.lab3.interactor.card;


import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.interactor.card.events.GetCardEvent;
import com.example.zizi.lab3.interactor.card.events.GetCardsEvent;
import com.example.zizi.lab3.interactor.card.events.GetEditableCardEvent;
import com.example.zizi.lab3.interactor.card.events.RemoveCardEvent;
import com.example.zizi.lab3.interactor.card.events.SaveCardEvent;
import com.example.zizi.lab3.interactor.card.events.UpdateFavouriteCardEvent;
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

    public void getCard(long cardId) {
        GetCardEvent event = new GetCardEvent();
        try {
            Card card = repository.getCard(cardId);
            // TODO fetch from backend and update the data in local db
            event.setCard(card);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    // TODO merge favourites with cards fetched from backend
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

    public void getEditableCard(long cardId) {
        GetEditableCardEvent event = new GetEditableCardEvent();
        try {
            // TODO get from backend
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
            // TODO transaction?
            if(card.getId() != null) {
                // TODO call backend update
                if(repository.isInDB(card)) {
                    repository.updateCard(card);
                }
            } else {
                // TODO call backend insert
            }
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateFavouriteCard(Card card) {
        UpdateFavouriteCardEvent event = new UpdateFavouriteCardEvent();
        event.setCard(card);
        try {
            if(card.isFavourite() || card.getComment() != null && !card.getComment().isEmpty()) {
                if(repository.isInDB(card)) {
                    repository.updateCard(card);
                } else {
                    repository.addCard(card);
                }
            } else {
                repository.removeFavourite(card);
            }

            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removeCard(Card card) {
        RemoveCardEvent event = new RemoveCardEvent();
        try {
            // TODO transaction?
            // TODO call backend delete
            repository.removeFavourite(card);
            // TODO update cards list event.setCards();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
