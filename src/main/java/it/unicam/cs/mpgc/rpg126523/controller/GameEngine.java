package it.unicam.cs.mpgc.rpg126523.controller;


import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskDefault;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskUniversity;

import java.util.List;

public class GameEngine {

    private Game game;
    private Student player;


    public GameEngine(Game game) {
        this.game = game;
    }

    public GameEngine(){

    }

    public boolean loadStudent(){
        //non c'è studente allora lo creo
        return false;
    }


    public void createPlayer(String idNumber, String name, Gender gender, StudentClass studentclass){
        PlayerStudentFactory playerStudentFactory = new PlayerStudentFactory();
        this.game= new Game(playerStudentFactory.createStudent(idNumber, name, gender, studentclass));
    }

    public Student showPlayer(){
        return game.getPlayerStudent();
    }

    public List<Task> getAvailableTasks() {
        return List.of(
                new TaskDefault(
                        "Decidi ci voler andare a dormire",
                        "Dormire",
                        8,
                        10,
                        0
                ),
                new TaskUniversity(
                        "Lezione",
                        "Andare a lezione",
                        2,
                        -2,
                        0,
                        101,
                        5
                ),
                new TaskUniversity(
                        "Studio in biblioteca",
                        "Ripassare gli appunti in biblioteca",
                        3,
                        -3,
                        0,
                        101,
                        4
                ),
                new TaskDefault(
                        "Uscire con gli amici a giocare a calcetto",
                        "Partita a calcetto",
                        2,
                        -3,
                        -3
                ),
                new TaskDefault(
                        "Mangiare qualcosa",
                        "Mangiare",
                        1,
                        5,
                        0
                )
        );
    }
}
