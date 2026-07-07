package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Resource;
import it.unicam.cs.mpgc.rpg126523.model.interfaces.Student;
import it.unicam.cs.mpgc.rpg126523.model.interfaces.ValueAdjustable;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class PlayerStudent implements Student {


    private final int idNumber;
    private final String name;
    private final Gender gender;
    private final Statistics statistics;

    //TODO: Da verificare l'idea
    private final Map<String, Resource> resources;


    private Map<Course, ValueAdjustable> knowledge;


    public PlayerStudent(int idNumber,String name, Gender gender, Statistics statistics) {
        if (idNumber<=0 || name == null || name.isEmpty()||statistics==null) throw new IllegalArgumentException();
        this.idNumber= idNumber;
        this.name = name;
        this.gender = gender;
        this.statistics = statistics;
        resources = new HashMap<>(Map.of(
                "Energia",new SimpleResource("Energia",0,30,30),
                "Stress",new SimpleResource("Stress",0,20,0)
        ));

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
