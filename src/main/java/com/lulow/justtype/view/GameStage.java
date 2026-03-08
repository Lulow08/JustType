package com.lulow.justtype.view;

import com.lulow.justtype.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage {
    public GameStage(Stage gameStage) throws IOException {

        loadFonts();

        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("/fxml/game-view.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        gameStage.setTitle("JustType");
        gameStage.setScene(scene);
        gameStage.show();
    }

    private void loadFonts() {
        Font.loadFont(
                getClass().getResourceAsStream("/fonts/Determination-Regular.ttf"),
                14
        );

        Font.loadFont(
                getClass().getResourceAsStream("/fonts/GeistMonoNerdFont-Regular.otf"),
                14
        );
    }
}
