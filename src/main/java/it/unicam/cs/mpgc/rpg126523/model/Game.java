package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Game {
    private int currentDay;
    @Setter
    private int targetDay;

    private final Student playerStudent;

    public Game(int currentDay, Student playerStudent) {
        this.currentDay = currentDay;
        this.playerStudent = playerStudent;
        setTargetDay(7);

    }

    public Game(Student player) {
      this(1,player);

    }

    public void incrementDay(){
        if(currentDay != targetDay)
             currentDay++;
    }


}
