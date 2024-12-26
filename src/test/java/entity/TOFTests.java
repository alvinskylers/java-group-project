package entity;

import org.entities.MultipleChoiceQuestion;
import org.entities.TrueOrFalseQuestion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TOFTests {

    String question = "Cats are awesome.";
    String answer = "true";
    TrueOrFalseQuestion tof = new TrueOrFalseQuestion(question, answer);

    @Test
    public void doesTOFExists() {
        assertEquals(question, tof.getQuestion());
        assertEquals(answer, tof.getAnswer());
        assertNull(tof.checkPass());
    }

    @Test
    public void tofAnsweredCorrectly() {
        tof.answerQuestion("TrUE");
        assertEquals(true, tof.checkPass());
    }

    @Test
    public void tofAnsweredIncorrectly() {
        tof.answerQuestion("FalSE");
        assertEquals(false, tof.checkPass());
    }
}
