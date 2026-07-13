package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.career.Career;
import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.consequences.ConsequencesApplier;
import it.unicam.cs.mpgc.rpg126523.model.resource.Resource;
import it.unicam.cs.mpgc.rpg126523.model.statistics.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;

import java.util.List;


public interface Student extends ConsequencesApplier {

    public String getName();

    public String getIdentifier();

    public Gender getGender();

    public Statistics getStatistics();

    public Resource getEnergy();

    public Resource getStress();

    public StudentClass getStudentClass();

    public void addSelectedCourses(List<Course> courses);

    public Career getCareer();
}
