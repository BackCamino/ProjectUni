package it.unicam.cs.mpgc.rpg126523.model.career;

import lombok.Getter;

import java.util.Objects;

/**
 * Rappresenta e contiene in dati essenziali per un corso universitario
 */
@Getter
public class Course {
    private final String name;
    private final int id;
    private final Exam exam;
    private CourseStatus status;


    public Course(String name, int id, Exam exam, CourseStatus status) {
        if(name == null ||  id < 0 || exam == null)
            throw new IllegalArgumentException("Uno o piu parametri non sono permessi");
        this.name = name;
        this.id = id;
        this.exam = exam;
        this.status = status;
    }

    public Course(String name, int id, Exam exam) {
        this(name, id, exam, CourseStatus.TO_ATTEND);
    }

    public void changeStatus(CourseStatus status){
        if(status== null) throw new NullPointerException("parametro nullo");
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
