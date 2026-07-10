package it.unicam.cs.mpgc.rpg126523.model.student;

import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;

public class PlayerStudentFactory implements StudentFactory {

    @Override
    public Student createStudent(String idNumber,String name, Gender gender, StudentClass studentClass) {

        return new PlayerStudent(idNumber, name,gender,studentClass);
    }
}
