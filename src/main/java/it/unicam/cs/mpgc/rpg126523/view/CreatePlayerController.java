package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CreatePlayerController {

    @FXML
    public TextField idNumber_txtfld;
    @FXML
    public TextField name_txtfld;
    @FXML
    public ChoiceBox class_choicebox;
    @FXML
    public void createPlayer() {
        System.out.println("Create Player");
    }
}
