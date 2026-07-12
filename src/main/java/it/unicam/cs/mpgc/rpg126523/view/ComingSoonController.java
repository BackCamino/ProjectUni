package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.FXML;

public class ComingSoonController implements HasNavigator{
    private Navigator navigator;
    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    public void goBack(){
        navigator.showMenu();
    }


}
