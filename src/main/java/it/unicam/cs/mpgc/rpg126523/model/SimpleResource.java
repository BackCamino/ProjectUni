package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Resource;

public class SimpleResource extends AbstractValutable implements Resource {

    private final String name;

    public SimpleResource(String name, int minValue, int maxValue, int initialValue) {
        super(minValue, maxValue, initialValue);
        this.name = name;
    }

    @Override
    public String getName() { return name; }
}