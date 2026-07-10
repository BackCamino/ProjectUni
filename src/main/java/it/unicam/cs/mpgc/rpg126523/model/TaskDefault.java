package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Task;

public class TaskDefault implements Task {

    private String description;
    private String name;


    @Override
    public TaskResult execute() {

        return null;
    }

    @Override
    public String getDescription() {
        return "";

    }
}
