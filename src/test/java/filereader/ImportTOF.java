package filereader;

import org.junit.jupiter.api.Test;
import org.players.QuizPlayer;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ImportTOF {

    Scanner sc = new Scanner(System.in);
    QuizPlayer quizPlayer = new QuizPlayer(sc, "mcq.txt", "tof.txt");


    @Test
    public void importFile() {
        quizPlayer.importTOF("tof.txt");
    }

    @Test
    public void doesQuizHaveQuestions() {
        quizPlayer.importTOF("tof.txt");
        assertFalse(quizPlayer.getQuizTOF().getQuestions().isEmpty());
    }


    @Test
    public void answerQuestion() {
        importFile();
        quizPlayer.getQuizTOF().getQuestion(0).answerQuestion("true");
        quizPlayer.getQuizTOF().getQuestion(1).answerQuestion("false");
    }

}
