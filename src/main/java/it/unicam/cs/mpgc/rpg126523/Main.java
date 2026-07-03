package it.unicam.cs.mpgc.rpg126523;

import it.unicam.cs.mpgc.rpg126523.model.Gender;
import it.unicam.cs.mpgc.rpg126523.model.PlayerStudent;
import it.unicam.cs.mpgc.rpg126523.model.factory.OverachieverFactory;
import it.unicam.cs.mpgc.rpg126523.model.factory.StatisticsFactory;
import it.unicam.cs.mpgc.rpg126523.model.interfaces.Student;


public class Main {
    static void main(String[] args) {
        StatisticsFactory factory = new OverachieverFactory();

        PlayerStudent s1 = new PlayerStudent(126523, "S1", Gender.FEMALE,factory.createStatistics());
        System.out.println(s1.toString());
    }
}
