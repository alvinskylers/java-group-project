package entity;

import org.entities.MultipleChoiceQuestion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MCQTests {

    String question = "are cats cute?";
    String[] options = {"yes", "no"};
    int answer = 0;
    MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(question, options, answer);

    @Test
    public void doesQuizExist(){
        assertEquals(question, mcq.getQuestion());
        assertEquals(options, mcq.getOptions());
        assertEquals(answer, mcq.getAnswer());
        assertNull(mcq.checkPass());
    }

    @Test
    public void quizAnsweredCorrectly() {
        mcq.answerQuestion(0);
        assertEquals(true, mcq.checkPass());
    }

    @Test void quizAnsweredIncorrectly() {
        mcq.answerQuestion(1);
        assertEquals(false, mcq.checkPass());
    }

}
