package io.shaeli.machinecoding.snakeandladder;

import java.util.List;

import io.shaeli.machinecoding.snakeandladder.models.Board;
import io.shaeli.machinecoding.snakeandladder.models.BoardDimension;
import io.shaeli.machinecoding.snakeandladder.models.Dice;
import io.shaeli.machinecoding.snakeandladder.models.EntityType;
import io.shaeli.machinecoding.snakeandladder.models.Game;
import io.shaeli.machinecoding.snakeandladder.models.Player;
import io.shaeli.machinecoding.snakeandladder.models.SpecialEntity;

public class GameLauncher {
    public static void launch() {
        InputLoader inputLoader = new InputLoader();

        BoardDimension boardDimension = inputLoader.getBoardSize();
        List<SpecialEntity> snakes = inputLoader.getSpecialEntity(EntityType.SNAKE);
        List<SpecialEntity> ladders = inputLoader.getSpecialEntity(EntityType.LADDER);

        Board board = new Board(boardDimension, snakes, ladders);

        Player player1 = inputLoader.getPlayer();
        Player player2 = inputLoader.getPlayer();

        Dice dice = new Dice(1, 6);
        Game game = new Game(board, dice);
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();


    }
}
