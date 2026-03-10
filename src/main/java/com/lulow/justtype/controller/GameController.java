package com.lulow.justtype.controller;

import com.lulow.justtype.model.GameLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GameController {

    @FXML private TextField inputField;

    // TODO: add initialize

    private GameLogic gameLogic = new GameLogic();

    @FXML
    private void onHandleSubmitButton() { submitAnswer(inputField.getText()); }

    @FXML
    private void onHandleEnter() { submitAnswer(inputField.getText()); }

    private void submitAnswer(String input) {
        gameLogic.processAnswer(input);
        inputField.clear();
    }
}