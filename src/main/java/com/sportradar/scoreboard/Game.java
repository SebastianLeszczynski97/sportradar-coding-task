package com.sportradar.scoreboard;

import java.util.Objects;

public class Game {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public Game(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
        this.awayTeam = awayTeam;
    }

    public Game(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, 0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return homeTeamScore == game.homeTeamScore && awayTeamScore == game.awayTeamScore && Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore);
    }

    @Override
    public String toString() {
        return "Game{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                '}';
    }

    public String toScoreFormat() {
        return homeTeam + " " + homeTeamScore + " - " + awayTeam +
                " " + awayTeamScore + "\n" ;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }
}
