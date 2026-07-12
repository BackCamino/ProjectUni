package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.career.Career;
import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.resource.SimpleResource;
import it.unicam.cs.mpgc.rpg126523.model.consequences.Consequences;
import it.unicam.cs.mpgc.rpg126523.model.resource.Resource;
import it.unicam.cs.mpgc.rpg126523.model.resource.ValueAdjustable;
import it.unicam.cs.mpgc.rpg126523.model.statistics.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import lombok.ToString;

import java.util.Map;

@ToString
public class PlayerStudent implements Student {

    private final String idNumber;
    private final String name;
    private final Gender gender;
    private final StudentClass studentClass;
    private final Statistics statistics;
    private final Resource energy;
    private final Resource stress;
    private Career career;
    private Map<Integer, ValueAdjustable> knowledge;


    public PlayerStudent(String idNumber,String name, Gender gender, StudentClass studentClass) {
        if (idNumber==null||idNumber.length()!=6 || name == null || name.isEmpty()||studentClass==null) throw new IllegalArgumentException();
        this.idNumber= idNumber;
        this.name = name;
        this.gender = gender;
        this.studentClass = studentClass;
        this.statistics = studentClass.createStatistics();
        energy = new SimpleResource("Energia",0,30,30);
        stress = new SimpleResource("Stress",0,20,0);

    }

    public PlayerStudent(String idNumber, String name, Gender gender, StudentClass studentClass, Statistics statistics, Resource energy, Resource stress) {
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.studentClass = studentClass;
        this.statistics = statistics;
        this.energy = energy;
        this.stress = stress;
    }


    @Override
    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return idNumber;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public Career getCareer() {
        return this.career;
    }
    @Override
    public Resource getEnergy() {
        return this.energy;
    }
    @Override
    public Resource getStress() {
        return this.stress;
    }

    @Override
    public void applyConsequences(Consequences result) {
        if(result.hasEnergyImpact())
            applyEnergy(result.deltaEnergy());
        if(result.hasStressImpact())
            applyStress(result.deltaStress());
        if(result.hasCourseReward())
            this.knowledge.get(result.idCourse()).increment(result.knowledge());
    }

    //TODO: da inserire che anche le statistiche fanno variare il delta
    private void applyEnergy(int delta){
        if(isIncrementValue(delta))
            this.energy.increment(delta);
        else if (isDecrementValue(delta))
            this.energy.decrement(Math.abs(delta));

    }

    private void applyStress(int delta){
        if(isIncrementValue(delta))
            this.stress.increment(delta);
        else if (isDecrementValue(delta))
            this.stress.decrement(Math.abs(delta));
    }

    private boolean isIncrementValue(int delta){
        return delta > 0;
    }

    private boolean isDecrementValue(int delta){
        return delta < 0;
    }


}
