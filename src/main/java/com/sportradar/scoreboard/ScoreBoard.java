package com.sportradar.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScoreBoard {
    List<Game> games = new ArrayList<Game>();

    public void addGame(Game game) {
        games.add(game);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        this.games = games.stream().filter(g -> !Objects.equals(g.getHomeTeam(), homeTeam) && !Objects.equals(g.getAwayTeam(), awayTeam)).collect(Collectors.toList());
    }

    public List<Game> getGames() {
        return games;
    }
}
