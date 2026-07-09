package it.unicam.cs.mpgc.rpg126523.view;

import it.unicam.cs.mpgc.rpg126523.model.student.Student;

public interface Navigator {

    public void showMenu();

    public void showNewPlayerCreation();

    public void showGame(Student player);
}
