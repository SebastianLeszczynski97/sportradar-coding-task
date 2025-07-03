package com.sportradar.scoreboard;

import com.sportradar.scoreboard.exceptions.InvalidScoreException;
import com.sportradar.scoreboard.exceptions.InvalidTeamException;
import com.sportradar.scoreboard.scoreboard.Game;
import com.sportradar.scoreboard.scoreboard.ScoreBoard;
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

        assertEquals("Can not add a match to scoreboard. Score can not be a negative number", exception.getMessage());
        assertEquals(scoreBoard.getGames().toString(), games.toString());
    }

    public void testShouldNotAllowToAddGameScoreIfOneOfTheTeamsIsCurrentlyPlaying() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game game1 = new Game("Poland", "England", 0, 0);
        scoreBoard.addGame(game1);
        Game gameWithTeamAlreadyPlaying = new Game("Poland", "France", 0, 0);

        Exception exception = assertThrows(InvalidTeamException.class, () -> {
            scoreBoard.addGame(gameWithTeamAlreadyPlaying);
        });

        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game("Poland", "England", 0, 0));

        assertEquals("Can not add a match to scoreboard. Selected team is currently playing a match", exception.getMessage());
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

        String expectedFormatedListOfGames = "Poland 0 - England 0\nGermany 0 - France 0\nItaly 0 - Spain 0";

        assertEquals(expectedFormatedListOfGames, scoreBoard.getCurrentResults());
    }
}
