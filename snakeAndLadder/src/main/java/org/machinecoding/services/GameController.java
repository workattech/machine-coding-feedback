package org.machinecoding.services;

import org.machinecoding.models.Board;
import org.machinecoding.models.Dice;
import org.machinecoding.models.Player;
import org.machinecoding.models.teleports.TeleporterEntity;
import org.machinecoding.strategy.DiceMovementStrategy;
import org.machinecoding.strategy.GameMovementStrategy;
import org.machinecoding.strategy.TeleporterMovementStrategy;

import java.util.List;

public class GameController {
    private final Board board;
    private final List<TeleporterEntity> teleports;
    private final List<Player> players;
    private final List<Dice> dices;

    private GameMovementStrategy movementStrategy;

    public GameController(Board board, List<TeleporterEntity> teleports, List<Player> players, List<Dice> dices) {
        this.board = board;
        this.teleports = teleports;
        this.players = players;
        this.dices = dices;

        this.movementStrategy = new GameMovementStrategy(new DiceMovementStrategy(dices), new TeleporterMovementStrategy(teleports));
    }

    public void start() {
        while(shouldPerformRound()){
            performOneRound();
        }
    }

    private boolean shouldPerformRound() {
        return players.stream().filter(p -> !p.isWinner()).count() > 1;
    }

    public void performOneRound(){
        for (Player player : players) {
            if(!shouldPerformRound()) return;

            int currentPosition = player.getPosition();
            int newPosition = movementStrategy.move(currentPosition);
            player.move(newPosition);

            System.out.println(player.getName() + " rolled a " + movementStrategy.getDiceValue() + " and moved from " +
                    currentPosition + " to " + player.getPosition());

            if (player.isWinner()) {
                System.out.println(player.getName() + " wins the game");
            }
        }
    }
}

