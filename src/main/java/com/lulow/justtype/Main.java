package com.lulow.justtype;

import com.lulow.justtype.view.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.setMainStage(mainStage);
        sceneManager.loadFonts();
        sceneManager.loadScene("/fxml/game-view.fxml");
    }
}