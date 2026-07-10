package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.career.Career;
import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.resource.SimpleResource;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskResult;
import it.unicam.cs.mpgc.rpg126523.model.resource.Resource;
import it.unicam.cs.mpgc.rpg126523.model.resource.ValueAdjustable;
import it.unicam.cs.mpgc.rpg126523.model.statistics.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class PlayerStudent implements Student {


    private final String idNumber;
    private final String name;
    private final Gender gender;
    private final StudentClass studentClass;
    private final Statistics statistics;
    private final Map<String, Resource> resources;

    private Career career;
    private Map<Course, ValueAdjustable> knowledge;


    public PlayerStudent(String idNumber,String name, Gender gender, StudentClass studentClass) {
        if (idNumber==null||idNumber.length()!=6 || name == null || name.isEmpty()||studentClass==null) throw new IllegalArgumentException();
        this.idNumber= idNumber;
        this.name = name;
        this.gender = gender;
        this.studentClass = studentClass;
        this.statistics = studentClass.createStatistics();

        //TODO: da migliorare qui
        resources = new HashMap<>(Map.of(
                "Energia",new SimpleResource("Energia",0,30,30),
                "Stress",new SimpleResource("Stress",0,20,0)
        ));

    }

    public PlayerStudent(String idNumber, String name, Gender gender, StudentClass studentClass, Statistics statistics, Map<String, Resource> resources) {
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.studentClass = studentClass;
        this.statistics = statistics;
        this.resources = resources;
    }


    @Override
    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return idNumber;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public Career getCareer() {
        return this.career;
    }


    public void applyTaskResult(TaskResult result) {

    }





}
