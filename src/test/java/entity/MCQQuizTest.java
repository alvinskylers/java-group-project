package entity;

import org.entities.MultipleChoiceQuestion;
import org.entities.QuizMCQ;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MCQQuizTest {

    //Create MCQs For Testing
    String question1 = "are dogs cute?";
    String[] options1 = {"yes", "no"};
    int answer1 = 1;
    MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion(question1, options1, answer1);

    String question2 = "are cats cute?";
    String[] options2 = {"yes", "no"};
    int answer2 = 0;
    MultipleChoiceQuestion mcq2 = new MultipleChoiceQuestion(question2, options2, answer2);

    String question3 = "do you want a cat?";
    String[] options3 = {"yes", "no"};
    int answer3 = 0;
    MultipleChoiceQuestion mcq3 = new MultipleChoiceQuestion(question3, options3, answer3);

    //Create MCQ Quiz
    String title = "Simple Pet Quiz";
    String description = "a quiz to find your pet";
    ArrayList<MultipleChoiceQuestion> questions = new ArrayList<>();
    QuizMCQ quiz = new QuizMCQ(title, description, questions);

    //Verify Object Exists
    @Test
    public void doesQuizExists() {
        assertEquals(title, quiz.getTitle());
        assertEquals(description, quiz.getDescription());
        assertTrue(questions.isEmpty());
    }

    //Add Questions
    @Test
    public void addingQuestions() {
        quiz.addQuestion(mcq1);
        quiz.addQuestion(mcq2);
        quiz.addQuestion(mcq3);
        assertNotNull(quiz);
    }

    //Answer Questions
    @Test
    public void answerCorrectly() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion(1);
        quiz.getQuestion(1).answerQuestion(0);
        quiz.getQuestion(2).answerQuestion(0);
    }

    @Test
    public void answerIncorrectly() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion(0);
        quiz.getQuestion(1).answerQuestion(1);
        quiz.getQuestion(2).answerQuestion(1);
    }

    @Test
    public void answerHalfCorrect() {
        addingQuestions();
        quiz.getQuestion(0).answerQuestion(0);
        quiz.getQuestion(1).answerQuestion(0);
        quiz.getQuestion(2).answerQuestion(0);
    }

    //Score Quiz
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
