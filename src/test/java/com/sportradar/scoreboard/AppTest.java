package com.sportradar.scoreboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testShouldCreateScoreBoard() {
        ScoreBoard scoreBoard = new ScoreBoard();

        assertNotNull(scoreBoard);
    }

    public void testShouldAddGameToScoreBoard() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game = new Game("Poland", "England", 0, 0);

        scoreBoard.addGame(game);

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland", "England", 0, 0));


        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }

    public void testShouldRemoveGameFromScoreboardAfterFinish() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game1 = new Game("Poland", "England", 0, 0);
        Game game2 = new Game("France", "Italy", 0, 0);
        scoreBoard.addGame(game1);
        scoreBoard.addGame(game2);
        scoreBoard.finishGame(game2.getHomeTeam(), game2.getAwayTeam());

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland", "England", 0, 0));

        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }

    public void testShouldUpdateGameScore() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game1 = new Game("Poland", "England", 0, 0);
        scoreBoard.addGame(game1);

        scoreBoard.updateGame(new Game(game1.getHomeTeam(), game1.getAwayTeam(), 1, 0));

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland", "England", 1, 0));

        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }

    public void testShouldNotAllowToUpdateGameScoreWithNegativeValues() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game1 = new Game("Poland", "England", 0, 0);
        scoreBoard.addGame(game1);

        Exception exception = assertThrows(InvalidScoreException.class, () -> {
            scoreBoard.updateGame(new Game(game1.getHomeTeam(), game1.getAwayTeam(), -1, 0));
        });

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland", "England", 0, 0));

        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }

    public void testShouldReturnFormatedListOfGames() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game1 = new Game("Poland", "England", 0, 0);
        Game game2 = new Game("Germany", "France", 0, 0);
        Game game3 = new Game("Italy", "Spain", 0, 0);
        scoreBoard.addGame(game1);
        scoreBoard.addGame(game2);
        scoreBoard.addGame(game3);

        String expectedFormatedListOfGames = "Poland 0 - England 0\n\nGermany 0 - France 0\n\nItaly 0 - Spain 0\n" ;

        assertEquals(expectedFormatedListOfGames, scoreBoard.getCurrentResults());
    }
}
