package org.main;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SnakeAndLadderGamePlayers implements GamePlayers{
    private ArrayList<Player> players;
    private ArrayList<Player> playersWon;

    public SnakeAndLadderGamePlayers() {
        this.players = new ArrayList<>();
        this.playersWon = new ArrayList<>();
    }

    public void LoadPlayers (ArrayList<String> players) {
        for (String name : players) {
            this.players.add(new Player(name));
        }
    }

    public Integer getNumOfPlayersWon() {
        return playersWon.size();
    }
}
