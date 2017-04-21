package com.example.zizi.lab3.test;

import com.example.zizi.lab3.BuildConfig;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.main.MainPresenter;
import com.example.zizi.lab3.ui.main.MainScreen;
import com.example.zizi.lab3.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.zizi.lab3.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CardTest {

    private MainPresenter mianPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mianPresenter = new MainPresenter();
    }

    @Test
    public void testGetCards() {
        MainScreen mainScreen = mock(MainScreen.class);
        mianPresenter.attachScreen(mainScreen);
        mianPresenter.getCards();

        ArgumentCaptor<List> cardsCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen, times(1)).showCards(cardsCaptor.capture());

        List<List> capturedCards = cardsCaptor.getAllValues();
        assertEquals(2, capturedCards.get(0).size());
    }

    @After
    public void tearDown() {
        mianPresenter.detachScreen();
    }
}