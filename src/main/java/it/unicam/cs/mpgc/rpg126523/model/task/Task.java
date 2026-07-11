package it.unicam.cs.mpgc.rpg126523.model.task;

public interface Task extends ConsequenceGenerator {

    String getDescription();

    void execute();

    int getDuration();

    boolean isPossibleToExecute();

}
