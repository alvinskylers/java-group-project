package org.entities;

import org.concepts.Question;
import org.interfaces.MultipleChoice;

public class MultipleChoiceQuestion extends Question implements MultipleChoice {
    private String[] options;
    private int answer;

    public MultipleChoiceQuestion(String question, String[] options, int answer) {
        super(question);
        this.options = options;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }


    @Override
    public void answerQuestion(int choice) {
        this.pass = (choice == answer);
    }

    @Override
    public Boolean checkPass() {
        return this.pass;
    }

}
