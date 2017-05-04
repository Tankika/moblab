package com.example.zizi.lab3.ui.editor;

import com.example.zizi.lab3.model.Card;

public interface EditorScreen {
    void showMessage(String message);

    void loadCard(Card card);

    void navigateBack();
}
