package com.example.zizi.lab3.ui.editor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zizi.lab3.MobSoftApplication;
import com.example.zizi.lab3.R;
import com.example.zizi.lab3.model.Card;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

public class EditorActivity extends AppCompatActivity implements EditorScreen {

    public final static String INTENT_EXTRA_CARD_ID = "INTENT_EXTRA_CARD_ID";

    private Tracker mTracker;

    @Inject
    EditorPresenter editorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editorPresenter.attachScreen(this);

        Intent intent = getIntent();
        Long cardId = intent.getLongExtra(INTENT_EXTRA_CARD_ID, -1);
        if(cardId != null) {
            editorPresenter.init(cardId);
        }

        mTracker.setScreenName("Image~" + getClass().getName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        editorPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_send:
                Card card = new Card();
                card.setName(((EditText) findViewById(R.id.name)).getText().toString());

                String mana = ((EditText) findViewById(R.id.mana)).getText().toString();
                if(!mana.isEmpty()) {
                    card.setMana(Integer.parseInt(mana));
                }

                String attack = ((EditText) findViewById(R.id.attack)).getText().toString();
                if(!mana.isEmpty()) {
                    card.setAttack(Integer.parseInt(mana));
                }

                String defense = ((EditText) findViewById(R.id.defense)).getText().toString();
                if(!mana.isEmpty()) {
                    card.setDefense(Integer.parseInt(mana));
                }

                editorPresenter.saveCard(card);
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadCard(Card card) {
        ((EditText) findViewById(R.id.name)).setText(card.getName());
        ((EditText) findViewById(R.id.mana)).setText(card.getMana());
        ((EditText) findViewById(R.id.attack)).setText(card.getAttack());
        ((EditText) findViewById(R.id.defense)).setText(card.getDefense());
    }

    @Override
    public void navigateBack() {
        onBackPressed();
    }
}
