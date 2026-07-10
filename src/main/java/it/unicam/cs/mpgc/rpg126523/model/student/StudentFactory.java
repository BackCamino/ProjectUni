package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;

public interface StudentFactory {

    public Student createStudent(String idNumber,String name, Gender gender, StudentClass classes);
}
