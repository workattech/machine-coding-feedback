package model;

import in.aghorii.snakeandladder.model.Board;
import in.aghorii.snakeandladder.model.Ladder;
import in.aghorii.snakeandladder.model.Player;
import in.aghorii.snakeandladder.model.Snake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardTest {

    @Test
    public void testBoard(){
        //Initialize
        List<Snake> snakes = new ArrayList<>(Collections.singletonList(new Snake(1, 2)));
        List<Ladder> ladders = new ArrayList<>(Collections.singletonList(new Ladder(1, 2)));
        List<Player> players = new ArrayList<>(Collections.singletonList(new Player("player 1")));

        //Execute
        Board board = new Board.BoardBuilder()
                .boardSize(101)
                .snakes(snakes)
                .ladders(ladders)
                .players(players)
                .build();

        //Assert
        Assertions.assertEquals(board.getBoardSize(), 101);
        Assertions.assertEquals(board.getSnakes().size(), 1);
        Assertions.assertEquals(board.getPlayers().size(), 1);
        Assertions.assertEquals(board.getPlayers().get(0).getName(), "player 1");
    }
}
