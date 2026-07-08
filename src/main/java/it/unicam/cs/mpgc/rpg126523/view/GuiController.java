package it.unicam.cs.mpgc.rpg126523.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Classe master che gestisce i vati scenari dell'applicazione
 */
public class GuiController {

    private final Stage stage;
    public GuiController(Stage stage) {
        this.stage = stage;
    }
    /**
     * Il metodo di avvio della gui, carica l'avvio dell'applicazione con il menu
     * @throws IOException
     */
    public void startApp() throws IOException {
        showMenu();
    }
    public void showMenu() throws IOException{
        this.stage.setTitle("ProjectUni");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
        Scene root = new Scene(loader.load());

        MenuController controller = loader.getController();
        controller.serGuiController(this);
        stage.setScene(root);
        stage.show();
    }

    public void showNewPlayerCreation()  {
        this.stage.setTitle("New Player");
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/create-player.fxml"));
            Scene root = new Scene(loader.load());
            stage.setScene(root);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
