package it.unicam.cs.mpgc.rpg126523.model.task;

import it.unicam.cs.mpgc.rpg126523.model.consequences.ConsequenceGenerator;
import it.unicam.cs.mpgc.rpg126523.model.consequences.Consequences;

public interface Task extends ConsequenceGenerator {

    String getDescription();

    int getDuration();

    Consequences execute();


    String getName();

}
