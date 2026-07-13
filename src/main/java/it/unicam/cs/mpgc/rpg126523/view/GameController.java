package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.controller.GameEngine;
import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StatisticType;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.view.custom.TaskCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


public class GameController implements HasNavigator, Initializable,HasGameEngine {
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
    @FXML
    public Text id_txt;
    @FXML
    Text energy_value;
    @FXML
    Text stress_value;
    @FXML
    ListView<Task> available_tasks;
    @FXML
    ListView<Task> daily_tasks;

    private GameEngine gameEngine;
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        available_tasks.setCellFactory(list -> new TaskCell());
        daily_tasks.setCellFactory(list -> new TaskCell());
        available_tasks.setOnMouseClicked(event -> {
            Task task = available_tasks.getSelectionModel().getSelectedItem();
            daily_tasks.getItems().add(task);
        });

        daily_tasks.setOnMouseClicked(event -> {
            daily_tasks.getItems().remove(daily_tasks.getSelectionModel().getSelectedItem());
        });

    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        displayPlayer();
        loadAvailableTasks(gameEngine.getAvailableTasks());
    }

    private void displayPlayer(){
        Student student= gameEngine.showPlayer();
        student.getGender();
        Map<Gender,String> genderImage= Map.of(Gender.MALE,"/images/avatars/boy/Boy_standard.png",Gender.FEMALE,"/images/avatars/girl/Girl.png",Gender.OTHER,"/images/avatars/genderless/Genderless.png");
        this.avatar_image.setImage(new Image(genderImage.get(student.getGender())));
        this.name_txt.setText(student.getName());
        this.id_txt.setText(student.getIdentifier());
        this.classes_txt.setText(student.getStudentClass().getName());
        this.vigor_value.setText(String.valueOf(student.getStatistics().getValueFromStatistic(StatisticType.VIGOR)));
        this.composure_value.setText(String.valueOf(student.getStatistics().getValueFromStatistic(StatisticType.COMPOSURE)));
        this.ingenuity_value.setText(String.valueOf(student.getStatistics().getValueFromStatistic(StatisticType.INGENUITY)));
        this.energy_value.setText(String.valueOf(student.getEnergy().getValue()));
        this.stress_value.setText(String.valueOf(student.getStress().getValue()));
    }

    private void loadAvailableTasks(List<Task> availableTasks){
        this.available_tasks.getItems().clear();
        this.available_tasks.getItems().addAll(availableTasks);
    }



}
