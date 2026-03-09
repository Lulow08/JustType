package com.lulow.justtype.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {

    @FXML private TextField inputField;

    @FXML
    private void onHandleValidate(ActionEvent actionEvent) {
        String word = inputField.getText();
        System.out.println(word);
        inputField.clear();
    }
}
