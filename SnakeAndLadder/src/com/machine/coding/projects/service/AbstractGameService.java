package com.machine.coding.projects.service;

public abstract class AbstractGameService implements GameService {

    private String winner;

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
