package org.entities;

import org.concepts.Quiz;
import org.interfaces.QuizProperties;

import java.util.ArrayList;

public class QuizTOF extends Quiz implements QuizProperties {
    private ArrayList<TrueOrFalseQuestion> tofs;

    public QuizTOF(String title, String description, ArrayList<TrueOrFalseQuestion> questions) {
        super(title, description);
        this.tofs = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public TrueOrFalseQuestion getQuestion(int index) {
        return this.tofs.get(index);
    }

    public ArrayList<TrueOrFalseQuestion> getQuestions() {
        return tofs;
    }

    private void setScore(int score){
        this.score = score;
    }

    public void addQuestion(TrueOrFalseQuestion question){
        tofs.add(question);
    }


    @Override
    public void scoreQuiz() {
        int totalQuestions = tofs.size();
        int score = 0;
        for (TrueOrFalseQuestion tof : tofs) {
            if(tof.checkPass()) {
                score++;
            }
        }
        setScore(score);
    }

    @Override
    public String viewScore() {
        return "scored: " + this.score + "/" + this.tofs.size();
    }
}
