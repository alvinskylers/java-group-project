package org.entities;

import org.concepts.Quiz;
import org.interfaces.QuizProperties;

import java.util.ArrayList;

public class QuizMCQ extends Quiz implements QuizProperties {
    private ArrayList<MultipleChoiceQuestion> mcqs;

    public QuizMCQ(String name, String description, ArrayList<MultipleChoiceQuestion> questions) {
        super(name, description);
        mcqs = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public MultipleChoiceQuestion getQuestion(int index){
        return mcqs.get(index);
    }

    public ArrayList<MultipleChoiceQuestion> getQuestions(){
        return mcqs;
    }

    public void addQuestion(MultipleChoiceQuestion question){
        mcqs.add(question);
    }

    private void setScore(int score){
        this.score = score;
    }

    @Override
    public void scoreQuiz() {
        int totalQuestions = mcqs.size();
        int score = 0;
        for (MultipleChoiceQuestion mcq : mcqs) {
            if(mcq.checkPass()) {
                score++;
            }
        }
        setScore(score);
    }

    @Override
    public String viewScore() {
        return "scored: "+ this.score  + "/" + mcqs.size();
    }
}
