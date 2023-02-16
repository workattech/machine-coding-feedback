package io.shaeli.machinecoding.snakeandladder.models;

import java.util.ArrayList;
import java.util.List;

import io.shaeli.machinecoding.snakeandladder.exceptions.InvalidMoveException;

public class Game {
    Board board;
    List<Player> players;
    Dice dice;
    int numActicePlayers;

    public Game(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        this.players = new ArrayList<>();
        this.numActicePlayers = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setPlaying(true);
        this.numActicePlayers++;
    }

    private boolean isOver() {
        return this.numActicePlayers < 2;
    }

    public void start() {
        while(!isOver()) {
            for(Player player : players) {
                if(player.isPlaying() && (!isOver())) {
                    try {
                        int nextPos = board.getNextPos(player.getPos(), dice.roll());
                        player.setPos(nextPos);
                        if (nextPos == board.getNumCells()) {
                            System.out.println("Player " + player.getName() + " Won !!!");
                            player.setPlaying(false);
                            this.numActicePlayers--;
                        }
                    } catch (InvalidMoveException exception) {
//                        exception.printStackTrace();
                    }
                }
            }
        }
    }

}
