package com.example.zizi.lab3.ui.details;

import com.example.zizi.lab3.model.Card;

public interface DetailsScreen {
    void showMessage(String message);

    void loadCard(Card card);
}
