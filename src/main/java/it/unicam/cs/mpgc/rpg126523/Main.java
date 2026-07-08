package it.unicam.cs.mpgc.rpg126523;


import it.unicam.cs.mpgc.rpg126523.controller.GuiController;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        GuiController t= new GuiController(primaryStage);
        t.startApp();
    }

}
