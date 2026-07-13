package it.unicam.cs.mpgc.rpg126523.model.exam;

public class GeneralExam implements Exam{
    private final int knowledgeRequired;
    private final String type;

    public GeneralExam(int knowledgeRequired, String type) {
        this.knowledgeRequired = knowledgeRequired;
        this.type = type;
    }

    @Override
    public String attempt(int knowledge) {
        return this.knowledgeRequired<knowledge? "Esame superato": "Bocciato";
    }
}
