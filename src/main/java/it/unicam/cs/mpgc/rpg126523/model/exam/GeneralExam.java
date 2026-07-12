package it.unicam.cs.mpgc.rpg126523.model.exam;

public class GeneralExam implements Exam{
    private final int knowledgeRequired;

    public GeneralExam(int knowledgeRequired) {
        this.knowledgeRequired = knowledgeRequired;
    }

    @Override
    public void attempt() {

    }
}
