package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Student;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlayerStudent implements Student {


    private final int idNumber;
    private final String name;
    private final Gender gender;
    private final Statistics statistics;
    //la conoscenza sara' riguardante un esame in particolare, da ricordarselo e modificare in futuro
    private int knowledge;

    private int energy;


    private int stress;


    public PlayerStudent(int idNumber,String name, Gender gender, Statistics statistics) {
        if (idNumber<=0 || name == null || name.isEmpty()||statistics==null) throw new IllegalArgumentException();
        this.idNumber= idNumber;
        this.name = name;
        this.gender = gender;
        this.statistics = statistics;
    }

    public int getIdentifier() {
        return idNumber;
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }


    public void applyTaskResult(TaskResult result) {

    }





}
