package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.controller.GameEngine;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Classe master che gestisce i vati scenari dell'applicazione
 */
public class GuiController implements Navigator {

    private final Stage stage;
    private final GameEngine gameEngine;
    public GuiController(Stage stage,GameEngine gameEngine) {
        this.stage = stage;
        this.gameEngine = gameEngine;
    }
    /**
     * Il metodo di avvio della gui, carica l'avvio dell'applicazione con il menu
     * @throws IOException
     */
    public void startApp() throws IOException {
        showMenu();
    }


    private void loadScene(String title, String path) {
        this.stage.setTitle(title);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Scene root = new Scene(loader.load());
            loadController(loader.getController());
            stage.setScene(root);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void loadController(Object controller) {
            if(controller instanceof HasNavigator hasNavigator) {
                hasNavigator.setNavigator(this);
            }
            if(controller instanceof HasGameEngine hasGameEngine) {
                hasGameEngine.setGameEngine(gameEngine);
            }
        }


    public void showMenu() {
        this.loadScene("Menu","/fxml/menu.fxml");
    }

    public void showNewPlayerCreation()  {
        this.loadScene("NewPlayerCreation","/fxml/create-player.fxml");
    }


    @Override
    public void showGame() {
        this.loadScene("ProjectUni","/fxml/game.fxml");
    }

    @Override
    public void showComingSoon() {
        this.loadScene("Coming Soon","/fxml/coming-soon.fxml");
    }

}
