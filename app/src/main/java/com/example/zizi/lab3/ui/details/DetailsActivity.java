package com.example.zizi.lab3.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.R;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }
    
    @Override
    void loadCard(Object card) {
        throw new UnsupportedOperationException();
    }
}
