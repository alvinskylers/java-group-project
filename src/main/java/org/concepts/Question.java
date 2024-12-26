package org.concepts;

public abstract class Question {
    protected String question;
    protected Boolean pass;

    public Question(String question) {
        this.question = question;
    }

    public abstract String getQuestion();

}