package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.FXML;

public class MenuController implements HasNavigator {
    private Navigator guiController;

    @Override
    public void setNavigator(Navigator navigator) {
        this.guiController = navigator;
    }

    @FXML
    public void newGame(){
        guiController.showNewPlayerCreation();
    }
    @FXML
    public void loadGame(){
        System.out.println("Load Game");
    }
    @FXML
    public void showGuide(){
        System.out.println("show Guide");
    }

}
