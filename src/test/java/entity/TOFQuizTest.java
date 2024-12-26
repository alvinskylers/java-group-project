package entity;

import org.entities.QuizTOF;
import org.entities.TrueOrFalseQuestion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TOFQuizTest {

    String question1 = "Cats are awesome.";
    String answer1 = "true";
    TrueOrFalseQuestion tof1 = new TrueOrFalseQuestion(question1, answer1);

    String question2 = "Dogs are awesome.";
    String answer2 = "true";
    TrueOrFalseQuestion tof2 = new TrueOrFalseQuestion(question2, answer2);

    String question3 = "Being Racist is awesome.";
    String answer3 = "true";
    TrueOrFalseQuestion tof3 = new TrueOrFalseQuestion(question3, answer3);

    String title = "Simple True or False Quiz";
    String description = "simple true or false quiz";
    ArrayList<TrueOrFalseQuestion> questions = new ArrayList<>();
    QuizTOF quiz = new QuizTOF(title,description,questions);

    @Test
    public void doesQuizExist() {
        assertEquals(title, quiz.getTitle());
        assertEquals(description, quiz.getDescription());
        assertTrue(questions.isEmpty());
    }

    @Test
    public void addingQuestions() {
        quiz.addQuestion(tof1);
        quiz.addQuestion(tof2);
        quiz.addQuestion(tof3);
    }

    @Test
    public void answerCorrectly() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion("true");
        quiz.getQuestion(1).answerQuestion("true");
        quiz.getQuestion(2).answerQuestion("true");
    }

    @Test
    public void answerHalfCorrect() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion("true");
        quiz.getQuestion(1).answerQuestion("true");
        quiz.getQuestion(2).answerQuestion("false");
    }

    @Test
    public void answerIncorrectly() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion("false");
        quiz.getQuestion(1).answerQuestion("false");
        quiz.getQuestion(2).answerQuestion("false");
    }

    @Test
    public void getScorePerfect() {
        answerCorrectly();
        quiz.scoreQuiz();
        assertEquals("scored: 3/3", quiz.viewScore());
    }

    @Test
    public void getScoreImperfect() {
        answerHalfCorrect();
        quiz.scoreQuiz();
        assertEquals("scored: 2/3", quiz.viewScore());
    }

    @Test
    public void getScoreFailed() {
        answerIncorrectly();
        quiz.scoreQuiz();
        assertEquals("scored: 0/3", quiz.viewScore());

    }

}
