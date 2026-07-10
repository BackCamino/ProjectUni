package it.unicam.cs.mpgc.rpg126523.controller;


import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;

public class GameEngine {

    private Game game;

    public GameEngine(Game game) {
        this.game = game;
    }

    public GameEngine(){

    }

    //nuova partita
    //1. si crea il game engine
    //2. si fa nuova partita
    //3. si crea lo studente
    //4. si costruisce la partita
    //5. si passa alla gestione grafica della partita


    public void createPlayer(String idNumber, String name, Gender gender, StudentClass studentclass){
        PlayerStudentFactory playerStudentFactory = new PlayerStudentFactory();
        this.game= new Game(playerStudentFactory.createStudent(idNumber, name, gender, studentclass));
    }



}
