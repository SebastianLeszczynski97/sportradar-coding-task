package com.sportradar.scoreboard;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ScoreBoard scoreBoard = new ScoreBoard();
        Game firstGame = new Game("Poland","England",0,0);
        scoreBoard.addGame(firstGame);

        System.out.println(scoreBoard.getGames().toString());
    }
}
