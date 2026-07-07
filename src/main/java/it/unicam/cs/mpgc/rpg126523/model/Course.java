package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Exam;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Course {
    private final String name;

    private final int id;
    private final String professor;

    private final Exam exam;
    private CourseStatus status;

    public Course(String name, int id, String professor, Exam exam, CourseStatus status) {
        if(name == null || professor == null || id < 0 || professor.isEmpty() || exam == null)
            throw new IllegalArgumentException("Uno o piu parametri non sono permessi");
        this.name = name;
        this.id = id;
        this.professor = professor;
        this.exam = exam;
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
