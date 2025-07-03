package com.sportradar.scoreboard.exceptions;

public class InvalidTeamException extends RuntimeException {
    public InvalidTeamException(String message) {
        super(message);
    }
}
