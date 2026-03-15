package com.lulow.justtype.controller;

import com.lulow.justtype.view.SceneManager;
import com.lulow.justtype.view.animations.FadeInAnimation;
import com.lulow.justtype.view.animations.OvershootAnimation;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;

public class LoseController {

    @FXML private AnchorPane rootPane;
    @FXML private Label      titleLabel;
    @FXML private Label      answerLabel;
    @FXML private Label      hintLabel;

    @FXML
    public void initialize() {
        SceneManager sceneManager = SceneManager.getInstance();

        HBox wordDisplay = sceneManager.getLoseWordDisplay();
        if (wordDisplay != null) {
            rootPane.getChildren().add(wordDisplay);
            AnchorPane.setLeftAnchor(wordDisplay, 0.0);
            AnchorPane.setRightAnchor(wordDisplay, 0.0);
        }

        answerLabel.setText("Your answer: " + sceneManager.getLoseAnswer());

        titleLabel.setOpacity(0);
        answerLabel.setOpacity(0);
        hintLabel.setOpacity(0);

        PauseTransition delay = new PauseTransition(Duration.seconds(1.6));
        delay.setOnFinished(event -> {
            titleLabel.setOpacity(1.0);
            new OvershootAnimation(titleLabel, 3.0, 0.88).play();
            new FadeInAnimation(answerLabel).play();
            new FadeInAnimation(hintLabel).play();
        });
        delay.play();

        rootPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)  onContinue();
            if (event.getCode() == KeyCode.ESCAPE) onGoMenu();
        });

        rootPane.sceneProperty().addListener((observableValue, oldScene, newScene) -> {
            if (newScene != null) rootPane.requestFocus();
        });
    }

    private void onContinue() {
        try {
            SceneManager.getInstance().loadScene("game-view.fxml");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void onGoMenu() {}
}