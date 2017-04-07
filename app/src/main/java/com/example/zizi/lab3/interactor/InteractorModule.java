package com.example.zizi.lab3.interactor;

import com.example.zizi.lab3.interactor.card.CardsInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public CardsInteractor provideCards() {
        return new CardsInteractor();
    }
}
