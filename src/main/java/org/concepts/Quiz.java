package org.concepts;

public abstract class Quiz {
    protected String title;
    protected String description;
    protected int score;

    public Quiz(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public abstract String getTitle();

    public abstract String getDescription();
}
