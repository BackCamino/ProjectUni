package it.unicam.cs.mpgc.rpg126523;


import it.unicam.cs.mpgc.rpg126523.controller.GameEngine;
import it.unicam.cs.mpgc.rpg126523.view.GuiController;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GameEngine gameEngine = new GameEngine();
        GuiController guiController= new GuiController(primaryStage,gameEngine);
        guiController.startApp();
    }

}
