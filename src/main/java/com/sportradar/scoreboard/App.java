package com.sportradar.scoreboard;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static final int FINISH_GAME_OPTION = 1;
    public static final int UPDATE_GAME_OPTION = 2;
    public static final int ADD_GAME_OPTION = 3;
    public static final int EXIT_APPLICATION_OPTION = 9;


    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        createExampleGames(scoreBoard);
        updateExampleGame(scoreBoard);

        displayScoreBoard(scoreBoard);
        displayOptions();

        handleUserInput(scoreBoard);
    }

    private static void handleUserInput(ScoreBoard scoreBoard) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        while (option != EXIT_APPLICATION_OPTION) {
            switch (option) {
                case FINISH_GAME_OPTION:
                    System.out.println("Please enter home team");
                    String homeTeam = input.next();
                    System.out.println("Please enter away team");
                    String awayTeam = input.next();
                    scoreBoard.finishGame(homeTeam, awayTeam);
                    break;

                case UPDATE_GAME_OPTION:
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
                case ADD_GAME_OPTION:
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

    private static void displayOptions() {
        System.out.println("To finish game press 1");
        System.out.println("To update game press 2");
        System.out.println("To add new game press 3");
        System.out.println("To close the application game press 9");
    }

    private static void displayScoreBoard(ScoreBoard scoreBoard) {
        System.out.println("CURRENT FOOTBALL WORLD CUP RESULTS: ");
        System.out.println("--------------------------");
        System.out.println(scoreBoard.getCurrentResults());
        System.out.println("--------------------------");
    }

    private static void createExampleGames(ScoreBoard scoreBoard) {
        Game firstGame = new Game("Poland", "England");
        Game secondGame = new Game("Germany", "France");
        Game thirdGame = new Game("Spain", "Italy");

        scoreBoard.addGame(firstGame);
        scoreBoard.addGame(secondGame);
        scoreBoard.addGame(thirdGame);
    }

    private static void updateExampleGame(ScoreBoard scoreBoard) {
        Game exampleGame = new Game("Poland", "England", 1, 0);
        scoreBoard.updateGame(exampleGame);
    }
}
