package com.example.zizi.lab3.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.R;
import com.example.zizi.lab3.model.Card;

import java.util.List;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    public final static String INTENT_EXTRA_CARD_ID = "INTENT_EXTRA_CARD_ID";

    private Menu mOptionsMenu;

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((EditText)findViewById(R.id.comment)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                detailsPresenter.setComment(s.toString());
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);

        Intent intent = getIntent();
        Long cardId = intent.getLongExtra(INTENT_EXTRA_CARD_ID, -1);
        detailsPresenter.init(cardId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        mOptionsMenu = menu;

        if(detailsPresenter.getCard().isFavourite()) {
            menu.findItem(R.id.action_make_favorite).setVisible(false);
            menu.findItem(R.id.action_make_unfavorite).setVisible(true);
        } else {
            menu.findItem(R.id.action_make_favorite).setVisible(true);
            menu.findItem(R.id.action_make_unfavorite).setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_make_favorite:
                detailsPresenter.markCardFaveourite();
                detailsPresenter.init(detailsPresenter.getCard().getId());
                return true;
            case R.id.action_make_unfavorite:
                detailsPresenter.unmarkCardFaveourite();
                detailsPresenter.init(detailsPresenter.getCard().getId());
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    @Override
    public void loadCard(Card card) {
        ((TextView) findViewById(R.id.name)).setText(card.getName());
        ((TextView) findViewById(R.id.mana)).setText("Mana:\t" + card.getMana());
        ((TextView) findViewById(R.id.attack)).setText("Támadás:\t" + card.getAttack());
        ((TextView) findViewById(R.id.defense)).setText("Védekezés:\t" + card.getDefense());
        ((TextView) findViewById(R.id.comment)).setText(card.getComment());

        if(mOptionsMenu != null) {
            if (detailsPresenter.getCard().isFavourite()) {
                mOptionsMenu.findItem(R.id.action_make_favorite).setVisible(false);
                mOptionsMenu.findItem(R.id.action_make_unfavorite).setVisible(true);
            } else {
                mOptionsMenu.findItem(R.id.action_make_favorite).setVisible(true);
                mOptionsMenu.findItem(R.id.action_make_unfavorite).setVisible(false);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
