package com.sportradar.scoreboard.scoreboard;

import com.sportradar.scoreboard.exceptions.InvalidScoreException;
import com.sportradar.scoreboard.exceptions.InvalidTeamException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScoreBoard {
    List<Game> games = new ArrayList<Game>();

    public void addGame(Game game) {
        List<String> currentlyPlayingHomeTeams = games.stream().map(Game::getHomeTeam).collect(Collectors.toList());
        List<String> currentlyPlayingAwayTeams = games.stream().map(Game::getAwayTeam).collect(Collectors.toList());

        if (currentlyPlayingAwayTeams.contains(game.getHomeTeam()) || currentlyPlayingAwayTeams.contains(game.getAwayTeam()) ||
                currentlyPlayingHomeTeams.contains(game.getHomeTeam()) || currentlyPlayingHomeTeams.contains(game.getAwayTeam())){
            throw new InvalidTeamException("Can not add a match to scoreboard. Selected team is currently playing a match");
        }
        games.add(game);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        this.games = games.stream().filter(g -> !Objects.equals(g.getHomeTeam(), homeTeam) && !Objects.equals(g.getAwayTeam(), awayTeam)).collect(Collectors.toList());
    }

    public void updateGame(Game game) {
        if (game.getAwayTeamScore() < 0 || game.getHomeTeamScore() < 0)
            throw new InvalidScoreException("Can not add a match to scoreboard. Score can not be a negative number");

        this.games = games.stream().filter(g -> !Objects.equals(g.getHomeTeam(), game.getHomeTeam()) && !Objects.equals(g.getAwayTeam(), game.getAwayTeam())).collect(Collectors.toList());
        this.games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public String getCurrentResults() {
        return games.stream().map(Game::toScoreFormat).collect(Collectors.joining("\n"));
    }
}
