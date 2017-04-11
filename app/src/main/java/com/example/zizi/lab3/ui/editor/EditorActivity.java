package com.example.zizi.lab3.ui.editor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.R;

import javax.inject.Inject;

public class EditorActivity extends AppCompatActivity implements EditorScreen {

    @Inject
    EditorPresenter editorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editorPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        editorPresenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadCard(Object card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void navigateBack() {
        throw new UnsupportedOperationException();
    }
}
