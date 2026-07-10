package it.unicam.cs.mpgc.rpg126523.model.career;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe Carriera, identifica una carriera universitaria di uno studente, contiene tutti i corsi che lo studente dovrà frequenta e passare per arrivare alla laurea
 */
public class Career {

    private final Set<Course> courses;

    public Career(Set<Course> courses){
        if(courses.isEmpty()) throw new IllegalArgumentException("Campo non valido, è vuoto");
        this.courses =courses;
    }

    /**
     * Metodo per la restituzione di tutti i corsi, indifferentemente dallo stato dei corsi
     * @return un insieme contente tutta la carriera dello studente
     */
    public Set<Course> getAllCareer(){
        return courses;
    }

    /**
     * Metodo per la restituzione di tutti i corsi che lo studente deve ancora frequentare
     * @return un insieme contenente tutti i corsi da frequentare
     */
    public Set<Course> getCoursesToAttend(){
       return courses.stream().filter(c->c.getStatus().equals(CourseStatus.TO_ATTEND)).collect(Collectors.toSet());
    }

    /**
     * Metodo per la restituzione di tutti i corsi passati, ovvero dove vi è stato il superamento dell'esame
     * @return un insieme di tutti i corsi sostenuti dallo studente
     */
    public Set<Course> getCoursesPassed(){
        return courses.stream().filter(c->c.getStatus().equals(CourseStatus.PASSED)).collect(Collectors.toSet());
    }


}
