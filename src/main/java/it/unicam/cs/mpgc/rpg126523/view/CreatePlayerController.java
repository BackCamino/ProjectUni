package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.controller.GameEngine;
import it.unicam.cs.mpgc.rpg126523.model.statistics.AthleteFactory;
import it.unicam.cs.mpgc.rpg126523.model.statistics.DiscriminatedFactory;
import it.unicam.cs.mpgc.rpg126523.model.statistics.OverachieverFactory;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;

public class CreatePlayerController implements Initializable,HasNavigator, HasGameEngine {

    public ToggleButton girlAvatar;
    public ToggleButton genderlessAvatar;
    private Navigator guiController;
    private GameEngine gameEngine;

    @FXML
    public TextField idNumber_txtfld;
    @FXML
    public TextField name_txtfld;
    @FXML
    public ChoiceBox<StudentClass> class_choicebox;
    @FXML
    ToggleGroup avatars;

    @FXML
    public ToggleButton boyAvatar;

    @FXML
    public void createPlayer() {
        Gender gender=(Gender) avatars.getSelectedToggle().getUserData();
        this.gameEngine.createPlayer(idNumber_txtfld.getText(),name_txtfld.getText(),gender, class_choicebox.getValue());
        guiController.showGame();
    }
    @Override
    public void setGameEngine(GameEngine gameEngine) {
        if(gameEngine==null)
            throw new NullPointerException("Game Engine is null");
        this.gameEngine = gameEngine;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ImageView images[] = {
                new ImageView(
                        new Image(getClass().getResource("/images/avatars/boy/Boy_standard.png").toExternalForm())
                ),
                new ImageView(
                        new Image(getClass().getResource("/images/avatars/girl/Girl.png").toExternalForm())
                ),
                new ImageView(
                        new Image(getClass().getResource("/images/avatars/genderless/Genderless.png").toExternalForm()))

        };

        for(ImageView image: images){
            image.setFitHeight(100);
            image.setFitWidth(100);
            image.setPreserveRatio(true);// serve per mantenere le proporzioni originali
        }

        boyAvatar.setGraphic(images[0]);
        boyAvatar.setUserData(Gender.MALE);
        girlAvatar.setGraphic(images[1]);
        girlAvatar.setUserData(Gender.FEMALE);
        genderlessAvatar.setGraphic(images[2]);
        class_choicebox.getItems().addAll(new AthleteFactory(),new DiscriminatedFactory(),new OverachieverFactory());
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.guiController = navigator;
    }
}
