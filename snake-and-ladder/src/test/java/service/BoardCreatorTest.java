package service;

import in.aghorii.snakeandladder.model.Board;
import in.aghorii.snakeandladder.model.Ladder;
import in.aghorii.snakeandladder.model.Player;
import in.aghorii.snakeandladder.model.Snake;
import in.aghorii.snakeandladder.service.creator.BoardCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardCreatorTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        BoardCreatorTest test = new BoardCreatorTest();

        test.testBoardCreator();
    }

    private void testBoardCreator() throws NoSuchFieldException, IllegalAccessException {
        //Initialize
        BoardCreator boardCreator = new BoardCreator();

        Field boardSizeField = BoardCreator.class.getDeclaredField("boardSize");
        boardSizeField.setAccessible(true);
        boardSizeField.set(boardCreator, 100);

        List<Snake> snakes = new ArrayList<>(Collections.singletonList(new Snake(1, 2)));
        List<Ladder> ladders = new ArrayList<>(Collections.singletonList(new Ladder(1, 2)));
        List<Player> players = new ArrayList<>(Collections.singletonList(new Player("player 1")));

        //Execute
        Board board = boardCreator.createBoard(snakes, ladders, players);

        //Assert
        if (board.getPlayers() != null && !"player 1".equals(board.getPlayers().get(0).getName())) {
            System.out.println("Test Failed");
        } else {
            System.out.println("Test Passed");
        }
    }
}
