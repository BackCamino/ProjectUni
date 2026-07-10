package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements HasNavigator, Initializable {
    @FXML
    public ImageView avatar_image;
    @FXML
    public Text name_txt;
    @FXML
    public Text classes_txt;
    @FXML
    public Text vigor_value;
    @FXML
    public Text ingenuity_value;
    @FXML
    public Text composure_value;

    private Navigator navigator;
    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
