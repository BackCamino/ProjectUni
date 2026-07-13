package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.controller.GameEngine;
import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StatisticType;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.view.custom.TaskCell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
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
    public Text days_remaining;
    public Text current_day;
    public ProgressBar cup_bar;
    public Button attempt_btn;
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
            updateProgress();
        });

        daily_tasks.setOnMouseClicked(event -> {
            daily_tasks.getItems().remove(daily_tasks.getSelectionModel().getSelectedItem());
            updateProgress();
        });
    }
    private void updateProgress() {
        double progress = (double) getHoursUsedToday() / 24;
        cup_bar.setProgress(progress);
    }


    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        displayPlayer();
        loadAvailableTasks(gameEngine.getAvailableTasks());
        loadDailyInfo();
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
        refreshResources(student);
    }

    private void loadAvailableTasks(List<Task> availableTasks){
        this.available_tasks.getItems().clear();
        this.available_tasks.getItems().addAll(availableTasks);
    }

    private void refreshResources(Student student){
        this.energy_value.setText(String.valueOf(student.getEnergy().getValue()));
        this.stress_value.setText(String.valueOf(student.getStress().getValue()));
    }

    @FXML
    void startDaily(ActionEvent event) {
        this.gameEngine.loadDailyTask(daily_tasks.getItems());
        this.gameEngine.runTask();
        refreshResources(this.gameEngine.showPlayer());
        refreshDailyInfo();
        updateProgress();

    }

    private void refreshDailyInfo(){
        this.days_remaining.setText(this.gameEngine.showDailyRemaining());
        this.current_day.setText(this.gameEngine.showCurrentDay());
        if(this.gameEngine.isExamDay()){
            this.attempt_btn.setDisable(false);
        }
    }

    private void loadDailyInfo(){
        refreshDailyInfo();

    }

    @FXML
    void attemptExam(ActionEvent event) {

        showAlert(this.gameEngine.attemptExam());
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Esito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private int getHoursUsedToday(){
        return this.daily_tasks.getItems().stream()
                .mapToInt(Task::getDuration) // Oppure usando la method reference: Task::getDuration
                .sum();
    }
}
