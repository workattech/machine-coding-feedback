package com.machine_coding.snakes_and_ladders.services.impl;

import com.machine_coding.snakes_and_ladders.entities.Board;
import com.machine_coding.snakes_and_ladders.entities.Ladder;
import com.machine_coding.snakes_and_ladders.entities.Player;
import com.machine_coding.snakes_and_ladders.entities.Snake;
import com.machine_coding.snakes_and_ladders.services.GameService;

import java.util.Random;


public class GameServiceImpl implements GameService {

    private Board board;
    private boolean didPlayerReachDestination;
    private final Random random = new Random();

    public GameServiceImpl(Board board) {
        this.board = board;
        this.didPlayerReachDestination = false;
    }

    private int getCurrentPlayer() {
        board.setCurrentPlayer(((board.getCurrentPlayer() + 1) % board.getPlayers().length));
        return board.getCurrentPlayer();
    }

    @Override
    public void runner() {

        if (board.getPlayers() == null || board.getPlayers().length == 0) return;
        while (!didPlayerReachDestination){
            this.play();
        }
    }

    private void play() {

        Player player = board.getPlayers()[this.getCurrentPlayer()];
        int diceValue = diceValue();
        if (player.getPosition() + diceValue > board.getSize()) return;
        int initialPosition = player.getPosition();
        int finalPosition = player.getPosition() + diceValue;
        if (board.getSnakes() != null) {
            for (Snake snake : board.getSnakes()){
                if (snake.getHead() == finalPosition){
                    finalPosition = snake.getTail();
                }
            }
        }
        if (board.getLadders() != null) {
            for (Ladder ladder : board.getLadders()){
                if (ladder.getDown() == finalPosition){
                    finalPosition = ladder.getTop();
                }
            }
        }
        player.setPosition(finalPosition);
        String out = player.getName() + " rolled a " + diceValue + " and moved from " + initialPosition + " to " + finalPosition;
        System.out.println(out);
        if (player.getPosition() == board.getSize()) {
            didPlayerReachDestination = true;
            out = player.getName() + " wins the game";
            System.out.println(out);
        }
    }

    private int diceValue() {
        return random.nextInt(6) + 1;
    }
}