package com.example.zizi.lab3.ui.editor;

import android.util.Log;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.interactor.card.CardsInteractor;
import com.example.zizi.lab3.interactor.card.events.GetEditableCardEvent;
import com.example.zizi.lab3.interactor.card.events.SaveCardEvent;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class EditorPresenter extends Presenter<EditorScreen> {

    @Inject
    CardsInteractor cardsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(EditorScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void init(final long cardId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.getEditableCard(cardId);
            }
        });
    }

    public void saveCard(final Card card) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cardsInteractor.saveCard(card);
            }
        });
    }

    public void onEventMainThread(GetEditableCardEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            if(event.getCard() == null) {
                screen.loadCard(new Object());
            } else {
                screen.loadCard(event.getCard());
            }
        }
    }

    public void onEventMainThread(SaveCardEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            Log.e("Networking", "Error reading favourites", event.getThrowable());

            screen.showMessage("error");
        } else {
            screen.navigateBack();
        }
    }
}
