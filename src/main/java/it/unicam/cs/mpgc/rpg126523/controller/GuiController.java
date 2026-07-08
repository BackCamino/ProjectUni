package it.unicam.cs.mpgc.rpg126523.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class GuiController {

    private final Stage stage;
    public GuiController(Stage stage) {
        this.stage = stage;
    }

    public void startApp() throws IOException {
        this.stage.setTitle("ProjectUni");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
        Scene root = new Scene(loader.load());
        stage.setScene(root);
        stage.show();

    }
}
