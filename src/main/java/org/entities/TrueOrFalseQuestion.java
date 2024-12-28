package org.entities;

import org.concepts.Question;
import org.interfaces.TrueOrFalse;

public class TrueOrFalseQuestion extends Question implements TrueOrFalse {

    private String answer;
    private String correctAnswer;
    public TrueOrFalseQuestion(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return answer;
    }


    @Override
    public void answerQuestion(String answer) {
        pass = this.answer.equalsIgnoreCase(answer);
    }

    @Override
    public Boolean checkPass() {
        return this.pass;
    }

    @Override
    public String toString() {
        String output = "Statement: ";
        output += "\n" + this.getQuestion();

        return output;
    }
}
