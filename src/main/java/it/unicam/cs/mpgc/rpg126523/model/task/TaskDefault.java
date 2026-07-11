package it.unicam.cs.mpgc.rpg126523.model.task;

public class TaskDefault implements Task {

    private final String description;
    private final String name;
    private int duration;

    public TaskDefault(String description,String name, int duration){
        if(description.isEmpty()||name.isEmpty()||duration<0)
            throw new IllegalArgumentException("Valori non validi per l'oggetto Task");
        this.name=name;
        this.description=description;
        this.duration=duration;
    }

    @Override
    public void execute() {
        generateConsequences();
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
        return null;
    }
}
