package it.unicam.cs.mpgc.rpg126523.model.task;

import it.unicam.cs.mpgc.rpg126523.model.consequences.ConsequenceGenerator;

public interface Task extends ConsequenceGenerator {

    String getDescription();

    void execute();

    int getDuration();

    boolean isPossibleToExecute();

    String getName();

}
