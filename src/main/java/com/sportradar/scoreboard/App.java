package com.sportradar.scoreboard;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game firstGame = new Game("Poland", "England");
        Game secondGame = new Game("Germany", "France");
        Game thirdGame = new Game("Spain", "Italy");

        scoreBoard.addGame(firstGame);
        scoreBoard.addGame(secondGame);
        scoreBoard.addGame(thirdGame);

        scoreBoard.updateGame(new Game("Poland", "England", 1, 0));

        displayScoreBoard(scoreBoard);
        displayOptions();

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        while (option != 9) {
            switch (option) {
                case 1:
                    System.out.println("Please enter home team");
                    String homeTeam = input.next();
                    System.out.println("Please enter away team");
                    String awayTeam = input.next();
                    scoreBoard.finishGame(homeTeam, awayTeam);
                    break;

                case 2:
                    System.out.println("Please enter home team");
                    String updatedHomeTeam = input.next();
                    System.out.println("Please enter away team");
                    String updatedAwayTeam = input.next();
                    System.out.println("Please enter home team score");
                    int updatedHomeTeamScore = input.nextInt();
                    System.out.println("Please enter away team score");
                    int updatedAwayTeamScore = input.nextInt();
                    try {
                        scoreBoard.updateGame(new Game(updatedHomeTeam, updatedAwayTeam, updatedHomeTeamScore, updatedAwayTeamScore));
                    } catch (InvalidScoreException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Please enter home team");
                    String newHomeTeam = input.next();
                    System.out.println("Please enter away team");
                    String newAwayTeam = input.next();
                    scoreBoard.addGame(new Game(newHomeTeam, newAwayTeam));
                    break;
            }
            displayScoreBoard(scoreBoard);
            displayOptions();

            option = input.nextInt();
        }
    }

    public static void displayOptions() {
        System.out.println("To finish game press 1");
        System.out.println("To update game press 2");
        System.out.println("To add new game press 3");
        System.out.println("To close the application game press 9");
    }

    public static void displayScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("Current score: ");
        System.out.println("--------------------------");
        System.out.println(scoreBoard.getCurrentResults());
        System.out.println("--------------------------");
    }
}
