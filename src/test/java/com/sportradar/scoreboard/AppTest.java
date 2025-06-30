package com.sportradar.scoreboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

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
        Game game = new Game("Poland","England",0,0);

        scoreBoard.addGame(game);

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland","England",0,0));


        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }
}
