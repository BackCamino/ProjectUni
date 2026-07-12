package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.FXML;

public class MenuController implements HasNavigator {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    public void newGame(){
        navigator.showNewPlayerCreation();
    }
    @FXML
    public void loadGame(){
        navigator.showComingSoon();
    }
    @FXML
    public void showGuide(){
      navigator.showComingSoon();
    }

}
