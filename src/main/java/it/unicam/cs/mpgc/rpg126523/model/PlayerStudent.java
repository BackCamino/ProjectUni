package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Student;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlayerStudent implements Student {

    //TODO: DA VALUTARE L'INSERIMENTO DI UNA MATRICOLA PER LO STUDENTE

    private final String name;
    private final Gender gender;
    private final Statistics statistics;


    public PlayerStudent(String name, Gender gender, Statistics statistics) {
        if (name == null || name.isEmpty()||statistics==null) throw new IllegalArgumentException();
        this.name = name;
        this.gender = gender;
        this.statistics = statistics;
    }



    @Override
    public Statistics getStatistics() {
        return statistics;
    }




}
