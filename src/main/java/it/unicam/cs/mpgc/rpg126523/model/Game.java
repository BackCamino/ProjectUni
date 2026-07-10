package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import lombok.Getter;

public class Game {
    private int currentDay;
    @Getter
    private Student  playerStudent;

    public Game(int currentDay, Student playerStudent) {
        this.currentDay = currentDay;
        this.playerStudent = playerStudent;
    }

    public Game(Student player) {
        this.playerStudent = player;
        this.currentDay = 1;
    }






}
