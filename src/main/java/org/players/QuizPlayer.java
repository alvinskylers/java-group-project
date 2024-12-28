package org.players;

import org.entities.MultipleChoiceQuestion;
import org.entities.QuizMCQ;
import org.entities.QuizTOF;
import org.entities.TrueOrFalseQuestion;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizPlayer {
    private Scanner input;
    private QuizMCQ quizMCQ;
    private QuizTOF quizTOF;
    private String fileMCQ;
    private String fileTOF;

    public static final String UIlines = "\n==============================================================================\n";

    public QuizPlayer(Scanner scanner, String fileMCQ, String fileTOF) {
        this.input = scanner;
        this.fileMCQ = fileMCQ;
        this.fileTOF = fileTOF;
    }

    public void start() {
        System.out.println("\n===================== Object Orientated Programming Quiz =====================\n");
        switch (chooseQuiz()) {
            case 1 :
                System.out.println("Importing Questions...");
                importMCQ(this.fileMCQ);
                playMCQ();
                System.out.print(UIlines);
                break;
            case 2 :
                System.out.println("Importing Questions...");
                importTOF(this.fileTOF);
                playTOF();
                System.out.print(UIlines);
                break;
            case 3 :
                System.out.println("Bye-bye!");
                System.out.print(UIlines);
                System.exit(0);
                break;
        }
    }

    public int chooseQuiz() {
        while (true) {
            System.out.println("Please pick a valid option: ");
            System.out.println("example: \"3\" ");
            System.out.println("[1] Multiple Choice Questions \n[2] True or False \n[3] Exit");
            System.out.print("Enter your choice: ");


            String choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
                System.out.println(UIlines);
                System.out.println("Invalid choice, please try again.");
            } else {
                return Integer.parseInt(choice);
            }
        }
    }

    public void importMCQ(String filename) {
        try (Scanner fileReader = new Scanner(Paths.get("src/main/resources/"+filename))) {
            ArrayList<String> lines = new ArrayList<>();
            while (fileReader.hasNextLine()) {
                lines.add(fileReader.nextLine());
            }

            String title = lines.get(0);
            String description = lines.get(1);
            ArrayList<MultipleChoiceQuestion> questions = new ArrayList<>();
            this.quizMCQ = new QuizMCQ(title, description, questions);

            for (int i = 2; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                if (data.length < 6) {
                    throw new IllegalArgumentException("Invalid data format in line: " + lines.get(i));
                }

                String question = data[0];
                ArrayList<String> options = new ArrayList<>();
                options.add(data[1]);
                options.add(data[2]);
                options.add(data[3]);
                options.add(data[4]);
                String[] choices = options.toArray(new String[0]);
                int answer = Integer.parseInt(data[5]);
                this.quizMCQ.addQuestion(new MultipleChoiceQuestion(question,choices, answer ));
            }

        } catch (Exception e) {
            new Exception(e);
            System.out.println(e);
        }
    }

    public void importTOF(String filename) {
        try (Scanner fileReader = new Scanner(Paths.get("src/main/resources/"+filename))) {
            ArrayList<String> lines = new ArrayList<>();
            while (fileReader.hasNextLine()) {
                lines.add(fileReader.nextLine());
            }

            String title = lines.get(0);
            String description = lines.get(1);
            ArrayList<TrueOrFalseQuestion> questions = new ArrayList<>();
            this.quizTOF = new QuizTOF(title, description, questions);

            for (int i = 2; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
                if (data.length < 2) {
                    throw new IllegalArgumentException("Invalid data format in line: " + lines.get(i));
                }

                String question = data[0];
                String answer = data[1];
                this.quizTOF.addQuestion(new TrueOrFalseQuestion(question,answer));
            }

        } catch (Exception e) {
            new Exception(e);
            System.out.println(e);
        }
    }

    public void playMCQ() {
        System.out.println("\n======================= Multiple Choice Question Quiz ========================\n");
        System.out.println(quizMCQ.getTitle());
        System.out.println(quizMCQ.getDescription());
        System.out.println("\nINSTRUCTIONS: ");
        System.out.println("Read the questions carefully.");
        System.out.println("answer by typing the number of the correct option.\n ");
        ArrayList<MultipleChoiceQuestion> questions = this.quizMCQ.getQuestions();
        for (MultipleChoiceQuestion question :questions) {
            System.out.println(question);
            System.out.print("your choice: ");
            String choice = input.nextLine();
            if (validateMCQAnswer(choice, question)){
                while (true) {
                    System.out.println(question);
                    System.out.print("your choice: ");
                    String pick = input.nextLine();
                    if(!validateMCQAnswer(pick, question)){
                        break;
                    }
                }
            }
        }

        this.quizMCQ.scoreQuiz();
        System.out.println("\nRESULTS: ");
        System.out.println("You " +quizMCQ.viewScore());

    }

    public void playTOF() {
        System.out.println("\n============================= True Or False Quiz =============================\n");
        System.out.println(quizTOF.getTitle());
        System.out.println(quizTOF.getDescription());
        System.out.println("\nINSTRUCTIONS: ");
        System.out.println("Read the statements carefully.");
        System.out.println("answer by typing \"True\" or \"False\". ");
        ArrayList<TrueOrFalseQuestion> questions = this.quizTOF.getQuestions();
        for (TrueOrFalseQuestion question : questions) {
            System.out.println();
            System.out.println(question);
            System.out.print("your answer: ");
            String choice = input.nextLine();
            if (validateTOFAnswer(choice, question)) {
                while (true) {
                    System.out.println(question);
                    System.out.print("your answer: ");
                    String pick = input.nextLine();
                    if(!validateTOFAnswer(pick, question)){
                        break;
                    }
                }
            }
        }

        this.quizTOF.scoreQuiz();
        System.out.println("\nRESULTS: ");
        System.out.println("You " +quizTOF.viewScore());
    }

    private boolean validateMCQAnswer(String answer, MultipleChoiceQuestion question) {
        if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")) {
            int option = Integer.parseInt(answer);
            question.answerQuestion(option);
            return false;
        } else {
            System.out.println("Invalid answer, please try again.\n");
            return true;
        }
    }

    private boolean validateTOFAnswer(String answer, TrueOrFalseQuestion question) {
        if (answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("false")) {
            question.answerQuestion(answer);
            return false;
        } else  {
            System.out.println("Invalid answer, please try again.\n");
            return true;
        }
    }

    public QuizMCQ getQuizMCQ() {
        return quizMCQ;
    }

    public QuizTOF getQuizTOF() {
        return quizTOF;
    }

}
