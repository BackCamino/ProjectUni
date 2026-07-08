package it.unicam.cs.mpgc.rpg126523;


import it.unicam.cs.mpgc.rpg126523.model.statistics.AthleteFactory;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.student.StudentFactory;

public class Main {
    static void main(String[] args) {
        Student student;
        StudentFactory studentFactory;
        studentFactory= new PlayerStudentFactory();
        StudentClass studentClass = new AthleteFactory();
        student= studentFactory.createStudent(124535,"marco", Gender.MALE,studentClass);
        System.out.println(student);
    }
}
