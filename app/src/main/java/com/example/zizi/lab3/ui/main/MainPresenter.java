package com.example.zizi.lab3.ui.main;

import android.util.Log;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.interactor.card.CardsInteractor;
import com.example.zizi.lab3.interactor.card.events.GetCardsEvent;
import com.example.zizi.lab3.interactor.card.events.RemoveCardEvent;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.zizi.lab3.repository.MemoryRepository.cards;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    CardsInteractor cardsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getCards() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.getCards();
            }
        });
    }

    public void deleteCard(final Card card) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.removeCard(card);
            }
        });
    }

    public void onEventMainThread(GetCardsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            screen.showCards(event.getCards());
        }
    }

    public void onEventMainThread(RemoveCardEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            screen.showCards(event.getCards());
        }
    }
}