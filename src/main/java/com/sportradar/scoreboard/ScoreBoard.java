package com.sportradar.scoreboard;

import java.util.ArrayList;

public class ScoreBoard {
    ArrayList<Game> games = new ArrayList<Game>();

    public void addGame(Game game) {
        games.add(game);
    }

    public ArrayList<Game> getGames(){
        return games;
    }
}
