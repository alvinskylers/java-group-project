package filereader;

import org.entities.MultipleChoiceQuestion;
import org.junit.jupiter.api.Test;
import org.players.QuizPlayer;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportMCQ {

    Scanner sc = new Scanner(System.in);
    QuizPlayer quizPlayer = new QuizPlayer(sc, "mcq.txt", "tof.txt");


    @Test
    public void importFile() {
        quizPlayer.importMCQ("mcq.txt");
    }

    @Test
    public void doesQuizHaveQuestions() {
        quizPlayer.importMCQ("mcq.txt");
        assertFalse(quizPlayer.getQuizMCQ().getQuestions().isEmpty());
    }


    @Test
    public void answerQuestion() {
        importFile();
        quizPlayer.getQuizMCQ().getQuestion(0).answerQuestion(4);
        quizPlayer.getQuizMCQ().getQuestion(0).answerQuestion(1);
    }

}
