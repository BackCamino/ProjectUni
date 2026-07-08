package it.unicam.cs.mpgc.rpg126523.controller;


import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;

public class GameController {

    private Student player;

    public void init(){

    }

    public GameController() {}

    public void createPlayer(int idNumber, String name, Gender gender, StudentClass studentclass){
        PlayerStudentFactory playerStudentFactory = new PlayerStudentFactory();
        this.player= playerStudentFactory.createStudent(idNumber, name, gender, studentclass);
    }
}
