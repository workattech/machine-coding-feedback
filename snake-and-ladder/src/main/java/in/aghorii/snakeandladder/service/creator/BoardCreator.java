package in.aghorii.snakeandladder.service.creator;

import in.aghorii.snakeandladder.model.Board;
import in.aghorii.snakeandladder.model.Ladder;
import in.aghorii.snakeandladder.model.Player;
import in.aghorii.snakeandladder.model.Snake;
import in.aghorii.snakeandladder.util.annotation.InjectProperty;

import java.util.List;

public class BoardCreator{

    @InjectProperty(value = "board.size")
    private int boardSize;

    public BoardCreator() {}

    public Board createBoard(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        return new Board
                .BoardBuilder()
                .boardSize(boardSize)
                .snakes(snakes)
                .ladders(ladders)
                .players(players)
                .build();
    }

}
