package com.lulow.justtype.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public final class SceneManager {

    private static SceneManager instance;
    private static Stage mainStage;

    private SceneManager() {}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    public void loadFonts() {
        Font.loadFont(
                getClass().getResourceAsStream("/fonts/Determination-Regular.ttf"),
                14
        );

        Font.loadFont(
                getClass().getResourceAsStream("/fonts/GeistMonoNerdFont-Regular.otf"),
                14
        );
    }

    public void loadScene(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.show();
    }
}
