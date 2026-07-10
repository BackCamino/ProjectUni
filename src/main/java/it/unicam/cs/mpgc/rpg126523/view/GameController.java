package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements HasNavigator {
    private Navigator navigator;
    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }


}
