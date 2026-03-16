package com.lulow.justtype.controller;

import com.lulow.justtype.model.AudioClips;
import com.lulow.justtype.model.AudioManager;
import com.lulow.justtype.view.MenuView;
import com.lulow.justtype.view.MenuView.MenuSelection;
import com.lulow.justtype.view.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class MenuController {

    @FXML private AnchorPane rootPane;
    @FXML private HBox       titleDisplay;
    @FXML private Label      newGameLabel;
    @FXML private Label      exitLabel;
    @FXML private Label      newGameIndicator;
    @FXML private Label      exitIndicator;

    private MenuView      menuView;
    private MenuSelection selection = MenuSelection.NEW_GAME;

    @FXML
    public void initialize() {
        menuView = new MenuView(rootPane, titleDisplay,
                newGameLabel, exitLabel, newGameIndicator, exitIndicator);

        menuView.setSelection(selection);
        menuView.start();

        AudioManager.getInstance().playMusic(AudioClips.MENU_MUSIC, true);

        rootPane.setOnKeyPressed(event -> handleKey(event.getCode()));
        rootPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) rootPane.requestFocus();
        });
    }

    private void handleKey(KeyCode code) {
        switch (code) {
            case UP, DOWN -> toggleSelection();
            case ENTER    -> confirm();
        }
    }

    private void toggleSelection() {
        selection = (selection == MenuSelection.NEW_GAME)
                ? MenuSelection.EXIT
                : MenuSelection.NEW_GAME;
        menuView.setSelection(selection);
    }

    private void confirm() {
        menuView.stop();
        if (selection == MenuSelection.NEW_GAME) {
            goToGame();
        } else {
            Platform.exit();
        }
    }

    private void goToGame() {
        try {
            SceneManager.getInstance().loadScene("game-view.fxml");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}