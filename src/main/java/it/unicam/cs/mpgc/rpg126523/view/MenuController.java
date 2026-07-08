package it.unicam.cs.mpgc.rpg126523.view;

import javafx.fxml.FXML;

public class MenuController {
    //TODO: Mettere un interfaccia Navigator per la navigazione
    private GuiController guiController;

    public void serGuiController(GuiController guiController) {
        this.guiController = guiController;
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
