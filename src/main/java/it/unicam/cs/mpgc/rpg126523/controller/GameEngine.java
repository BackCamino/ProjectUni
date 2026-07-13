package it.unicam.cs.mpgc.rpg126523.controller;


import it.unicam.cs.mpgc.rpg126523.model.Game;
import it.unicam.cs.mpgc.rpg126523.model.career.Course;
import it.unicam.cs.mpgc.rpg126523.model.exam.Exam;
import it.unicam.cs.mpgc.rpg126523.model.exam.GeneralExam;
import it.unicam.cs.mpgc.rpg126523.model.statistics.StudentClass;
import it.unicam.cs.mpgc.rpg126523.model.student.Gender;
import it.unicam.cs.mpgc.rpg126523.model.student.PlayerStudentFactory;
import it.unicam.cs.mpgc.rpg126523.model.student.Student;
import it.unicam.cs.mpgc.rpg126523.model.task.Task;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskDefault;
import it.unicam.cs.mpgc.rpg126523.model.task.TaskUniversity;
import it.unicam.cs.mpgc.rpg126523.persistence.dom.TaskXmlReader;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameEngine {

    private Game game;
    private Student player;
    private List<Task> daily_tasks;
    private Set<Course> courseSelected;
    private Course nextExamCourse;
    private TaskXmlReader taskXmlReader;


    public GameEngine(Game game) {
        this.game = game;
    }

    public GameEngine(){
        selectCoursesToFollow();
        taskXmlReader= new TaskXmlReader("/xml/tasks.xml");

        nextExamCourse = this.courseSelected.stream().filter(c->c.getId()==101).findFirst().get();

    }

    public void selectCoursesToFollow(){
        this.courseSelected=Set.of(new Course(101,"Programmazione",12, new GeneralExam(40,"general")));
    }

    public boolean loadStudent(){
        //non c'è studente allora lo creo
        return false;
    }


    public void createPlayer(String idNumber, String name, Gender gender, StudentClass studentclass){
        PlayerStudentFactory playerStudentFactory = new PlayerStudentFactory();
        this.player= playerStudentFactory.createStudent(idNumber, name, gender, studentclass);
        this.player.addSelectedCourses(courseSelected);
        this.game= new Game(this.player);
    }

    public Student showPlayer(){
        return game.getPlayerStudent();
    }

    public String showDailyRemaining(){
        return String.valueOf(this.game.getTargetDay()-this.game.getCurrentDay());
    }

    public void runTask(){
        if(checkCup()){
            daily_tasks.stream().map(Task::execute).forEach(c->player.applyConsequences(c));
            this.daily_tasks.clear();
            this.game.incrementDay();
        }

    }

    private boolean checkCup(){
        int totaleDurata = this.daily_tasks.stream()
                .mapToInt(Task::getDuration) // Oppure usando la method reference: Task::getDuration
                .sum();
        return totaleDurata <=24;
    }

    public List<Task> getAvailableTasks() {
        return taskXmlReader.loadTasks();
    }

    public void loadDailyTask(List<Task> items) {
        this.daily_tasks = items;
    }

    public String showCurrentDay() {
        return String.valueOf(this.game.getCurrentDay());
    }

    public boolean isExamDay() {
        return this.game.getCurrentDay()==this.game.getTargetDay();
    }

    public String attemptExam() {
        return this.nextExamCourse.getExam().attempt(this.player.getKnowledgePoints(nextExamCourse.getId()));
    }
}
