package it.unicam.cs.mpgc.rpg126523.model.task;

import it.unicam.cs.mpgc.rpg126523.model.consequences.Consequences;

public class TaskDefault implements Task {

    private final String description;
    private final String name;
    private final int duration;
    private final int deltaEnergy;
    private final int deltaStress;


    public TaskDefault(String description,String name, int duration, int deltaEnergy,int deltaStress){
        if(description.isEmpty()||name.isEmpty()||duration<0)
            throw new IllegalArgumentException("Valori non validi per l'oggetto Task");
        this.name=name;
        this.description=description;
        this.duration=duration;
        this.deltaEnergy=deltaEnergy;
        this.deltaStress=deltaStress;
    }

    @Override
    public String getName(){
        return this.name;
    }


    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public boolean isPossibleToExecute() {
        return false;
    }

    @Override
    public String getDescription() {
        return description;

    }


    @Override
    public Consequences generateConsequences() {
        return new Consequences(deltaEnergy,deltaStress);

    }
}
