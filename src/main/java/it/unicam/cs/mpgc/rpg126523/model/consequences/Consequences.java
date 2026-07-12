package it.unicam.cs.mpgc.rpg126523.model.consequences;

import it.unicam.cs.mpgc.rpg126523.model.career.Course;

public record Consequences(int deltaEnergy, int deltaStress, Integer idCourse, int knowledge ) {

    public Consequences(int deltaEnergy, int deltaStress) {
        this(deltaEnergy, deltaStress, null, 0); // Chiama il costruttore principale
    }

    public boolean hasCourseReward(){
        return idCourse != null;
    }

    public boolean hasStressImpact(){
        return deltaStress !=0;
    }
    public boolean hasEnergyImpact(){
        return deltaEnergy!=0;
    }

}
