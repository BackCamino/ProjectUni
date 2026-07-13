package it.unicam.cs.mpgc.rpg126523.model.task;

import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.consequences.Consequences;

public class TaskUniversity implements Task {
    private final String description;
    private final String name;
    private final int duration;
    private final int deltaEnergy;
    private final int deltaStress;
    private final Integer idCourse;
    private final int knowledge;
    public TaskUniversity(String name,String description,int duration, int deltaEnergy, int deltaStress, Integer idCourse, int knowledge) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.deltaEnergy = deltaEnergy;
        this.deltaStress = deltaStress;
        this.idCourse = idCourse;
        this.knowledge = knowledge;
    }

    @Override
    public String getDescription() {
        return this.description;
    }



    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public boolean isPossibleToExecute() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Consequences generateConsequences() {
        return new Consequences(deltaEnergy,deltaStress,idCourse,knowledge);
    }
}
