package com.example.zizi.lab3.ui.main;

import com.example.zizi.lab3.model.Card;

import java.util.List;

public interface MainScreen {
    void showMessage(String message);

    void showCards(List<Card> cards);

    void deleteCard(Long cardId);
}