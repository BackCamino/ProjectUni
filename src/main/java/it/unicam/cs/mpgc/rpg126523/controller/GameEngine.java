package it.unicam.cs.mpgc.rpg126523.controller;


import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.exam.GeneralExam;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskDefault;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskUniversity;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private Game game;
    private Student player;
    private List<Task> daily_tasks;


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
        this.player= playerStudentFactory.createStudent(idNumber, name, gender, studentclass);
        this.player.addSelectedCourses(List.of(new Course(101,"Programmazione",12, new GeneralExam(40,"general"))));
        this.game= new Game(this.player);
    }

    public Student showPlayer(){
        return game.getPlayerStudent();
    }

    public String showDailyRemaining(){
        return String.valueOf(this.game.getTargetDay()-this.game.getCurrentDay());
    }

    public void runTask(){
        if(checkCup()){
            daily_tasks.stream().map(Task::execute).forEach(c->player.applyConsequences(c));
        }
        this.daily_tasks.clear();
        this.game.incrementDay();


    }

    private boolean checkCup(){
        int totaleDurata = this.daily_tasks.stream()
                .mapToInt(Task::getDuration) // Oppure usando la method reference: Task::getDuration
                .sum();
        return totaleDurata <=24;
    }

    //TODO: DA LEVARE
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

    public void loadDailyTask(List<Task> items) {
        this.daily_tasks = items;
    }

    public String showCurrentDay() {
        return String.valueOf(this.game.getCurrentDay());
    }
}
