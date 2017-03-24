package com.example.zizi.lab3;

import com.example.zizi.lab3.ui.UIModule;
import com.example.zizi.lab3.ui.editor.EditorActivity;
import com.example.zizi.lab3.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(EditorActivity editorActivity);
}
