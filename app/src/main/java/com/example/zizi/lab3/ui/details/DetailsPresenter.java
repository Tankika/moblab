package com.example.zizi.lab3.ui.details;

import android.util.Log;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.interactor.card.CardsInteractor;
import com.example.zizi.lab3.interactor.card.events.GetCardEvent;
import com.example.zizi.lab3.interactor.card.events.GetCardsEvent;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.Presenter;
import com.example.zizi.lab3.ui.main.MainScreen;

import java.util.Arrays;
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

    public void addComment(String comment) {
    }

    public void markCardFaveourite() {
    }

    public void unmarkCardFaveourite() {
    }

}
