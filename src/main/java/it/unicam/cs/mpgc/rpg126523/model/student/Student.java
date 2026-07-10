package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.statistics.Statistics;



public interface Student {

    public String getName();

    public String getIdentifier();

    public Gender getGender();

    public Statistics getStatistics();

    //public Resources getResources();
}
