package com.example.zizi.lab3.ui.details;

import android.util.Log;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.interactor.card.CardsInteractor;
import com.example.zizi.lab3.interactor.card.events.GetCardEvent;
import com.example.zizi.lab3.interactor.card.events.UpdateFavouriteCardEvent;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Inject
    CardsInteractor cardsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    private Card card;

    public void init(final long cardId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.getCard(cardId);
            }
        });
    }

    public void setComment(String comment) {
        card.setComment(comment);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.updateFavouriteCard(card);
            }
        });
    }

    public void markCardFaveourite() {
        card.setFavourite(false);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.updateFavouriteCard(card);
            }
        });
    }

    public void unmarkCardFaveourite() {
        card.setFavourite(false);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.updateFavouriteCard(card);
            }
        });
    }

    public void onEventMainThread(GetCardEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            screen.loadCard(event.getCard());
        }
    }

    public void onEventMainThread(UpdateFavouriteCardEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            screen.loadCard(event.getCard());
        }
    }

}
