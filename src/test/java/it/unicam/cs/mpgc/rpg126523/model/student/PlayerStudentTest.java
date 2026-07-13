package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.statistics.AthleteFactory;
import it.unicam.cs.mpgc.rpg126523.model.consequences.Consequences;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskDefault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerStudentTest {

    private Student student;
    @BeforeEach
    void setUp() {
        student= (new PlayerStudentFactory()).createStudent("124523","Marco",Gender.MALE,new AthleteFactory());
    }

    @Test
    void getEnergy() {
    }

    @Test
    void getStress() {
    }

    @Test
    void applayConsequencesTaskResult() {
        Task t1=new TaskDefault("Prova1","t1",3,-5,6);
        System.out.println("Stress: "+student.getStress().getValue());
        System.out.println("Energia:" +student.getEnergy().getValue());

        Consequences c1= t1.generateConsequences();

        student.applyConsequences(c1);
        System.out.println("Stress:"+ student.getStress().getValue());
        System.out.println("Energia:"+ student.getEnergy().getValue());
        student.applyConsequences(c1);
        System.out.println("Stress:"+ student.getStress().getValue());
        System.out.println("Energia:"+ student.getEnergy().getValue());
        student.applyConsequences(c1);
        student.applyConsequences(c1);
        student.applyConsequences(c1);
        System.out.println("Stress:"+ student.getStress().getValue());
        System.out.println("Energia:"+ student.getEnergy().getValue());

    }
}