package it.unicam.cs.mpgc.rpg126523.model.interfaces;

import it.unicam.cs.mpgc.rpg126523.model.Gender;
import it.unicam.cs.mpgc.rpg126523.model.Statistics;



public interface Student {

    public String getName();

    public int getIdentifier();

    public Gender getGender();

    public Statistics getStatistics();

    ;

    //public Resources getResources();
}
