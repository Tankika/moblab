package com.example.zizi.lab3;

import com.example.zizi.lab3.interactor.InteractorModule;
import com.example.zizi.lab3.interactor.card.CardsInteractor;
import com.example.zizi.lab3.repository.RepositoryModule;
import com.example.zizi.lab3.ui.UIModule;
import com.example.zizi.lab3.ui.details.DetailsActivity;
import com.example.zizi.lab3.ui.details.DetailsPresenter;
import com.example.zizi.lab3.ui.editor.EditorActivity;
import com.example.zizi.lab3.ui.editor.EditorPresenter;
import com.example.zizi.lab3.ui.main.MainActivity;
import com.example.zizi.lab3.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainPresenter mainPresenter);

    void inject(MainActivity mainActivity);

    void inject(EditorPresenter editorPresenter);

    void inject(EditorActivity editorActivity);

    void inject(DetailsPresenter detailsPresenter);

    void inject(DetailsActivity detailsActivity);

    void inject(CardsInteractor cardsInteractor);
}
