package it.unicam.cs.mpgc.rpg126523.view.custom;

import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;


public class TaskCell extends ListCell<Task> {
    @Override
    protected void updateItem(Task task, boolean empty) {
        super.updateItem(task, empty);
        if (empty || task == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            VBox card = new VBox();
            card.getStyleClass().add("task-card");

            Text title = new Text(task.getName());
            Text desc = new Text(task.getDescription());
            HBox hbox= new HBox();
            hbox.setAlignment(Pos.BASELINE_LEFT);
            Label durationLabel= new Label("Durata: ");
            Text duration= new Text(String.valueOf(task.getDuration()));
            hbox.getChildren().addAll(durationLabel, duration);
            card.getChildren().addAll(title, desc, hbox);
            setGraphic(card);
            setText(null);
        }
    }
}
