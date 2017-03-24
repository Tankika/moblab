package com.example.zizi.lab3.ui;

import android.content.Context;

import com.example.zizi.lab3.ui.details.DetailsPresenter;
import com.example.zizi.lab3.ui.editor.EditorPresenter;
import com.example.zizi.lab3.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public EditorPresenter provideEditorPresenter() {
        return new EditorPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

}