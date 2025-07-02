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
        Game secondGame = new Game("Germany","France",0,0);
        Game thirdGame = new Game("Spain","Italy",0,0);

        scoreBoard.addGame(firstGame);
        scoreBoard.addGame(secondGame);
        scoreBoard.addGame(thirdGame);

        String results = scoreBoard.getCurrentResults();

        System.out.println(results);
    }
}
