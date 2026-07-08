package it.unicam.cs.mpgc.rpg126523;


import it.unicam.cs.mpgc.rpg126523.model.statistics.AthleteFactory;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.student.StudentFactory;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Menu");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
