package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.career.Career;
import it.unicam.cs.mpgc.rpg126523.model.consequences.ConsequencesApplier;
import it.unicam.cs.mpgc.rpg126523.model.resource.Resource;
import it.unicam.cs.mpgc.rpg126523.model.statistics.Statistics;


public interface Student extends ConsequencesApplier {

    public String getName();

    public String getIdentifier();

    public Gender getGender();

    public Statistics getStatistics();

    public Resource getEnergy();

    public Resource getStress();

    public Career getCareer();
}
