package org.app;

import org.players.QuizPlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QuizPlayer quiz = new QuizPlayer(scanner, "mcq.txt", "tof.txt");
        quiz.start();
    }
}