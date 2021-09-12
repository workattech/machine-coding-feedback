package com.workAtTech.snakeAndLadderApp;

import com.workAtTech.snakeAndLadderApp.model.Board;
import com.workAtTech.snakeAndLadderApp.model.Ladder;
import com.workAtTech.snakeAndLadderApp.model.Player;
import com.workAtTech.snakeAndLadderApp.model.Snake;

import java.util.*;

public class SnakeAndLadderAppService {
    private static final int DEFAULT_BOARD_SIZE = 100; //Rule1 : The board will have 100 cells numbered from 1 to 100.
    private static final int DEFAULT_NO_OF_DICES = 1;
    private Board board;
    private Queue<Player> players; // Players will be added one by one hence used queue
    private int numOfDices;
    private DiceService diceServiceObj;
    private int numberOfPlayers;

    public SnakeAndLadderAppService() {
        this.board = new Board(DEFAULT_BOARD_SIZE);
        this.players = new LinkedList<Player>();
        this.numOfDices = SnakeAndLadderAppService.DEFAULT_NO_OF_DICES;
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.numberOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getId(), 0); // Rule3 : Each player has a piece which is initially kept outside the board (i.e., at position 0).
        }
        board.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders);
    }

    public void startApp() {
        do {
            diceServiceObj = new DiceService();
            int diceValue = diceServiceObj.roll(); //Rule 4: Each player rolls the dice when their turn comes.
            Player playerCurrentPosition = players.poll(); //can use remove() but it will throw NoSuchElementException when queue is empty
            movedPlayer(playerCurrentPosition, diceValue);
            if (checkPlayerWon(playerCurrentPosition)) {
                System.out.println(playerCurrentPosition.getName() + " wins the game");
                board.getPlayerPieces().remove(playerCurrentPosition.getId());
            } else {
                players.add(playerCurrentPosition);
            }
        } while (!(players.size() < numberOfPlayers));
    }

    private boolean checkPlayerWon(Player player) {
        int playerCurrentPosition = board.getPlayerPieces().get(player.getId());
        return playerCurrentPosition == board.getBoardSize(); // Rule 6 : A player wins if it exactly reaches the position 100 and the game ends there.
    }

    /*
     **Rule 5 : Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 5 and the piece is at position 21, the player will put their piece at position 26 now (21+5).
     **Rule 7: After the dice roll, if a piece is supposed to move outside position 100, it does not move.
     **Rule 8: The board also contains some snakes and ladders.
     */
    private void movedPlayer(Player player, int diceValue) {
        int oldPosition = board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + diceValue;
        int boardSize = board.getBoardSize();
        if (newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getPositionAfterSnakesAndLadders(newPosition);
        }
        board.getPlayerPieces().put(player.getId(), newPosition);
        System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + oldPosition + " to " + newPosition);
    }

    /*
     **Rule10 : Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
     **Rule 12 :Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
     **Rule 13: There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
     */
    private int getPositionAfterSnakesAndLadders(int newPosition) {
        int oldPosition;
        do {
            oldPosition = newPosition;
            for (Snake snake : board.getSnakes()) {
                if (snake.getHead() == newPosition) {
                    newPosition = snake.getTail();
                }
            }
            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != oldPosition);
        return newPosition;
    }
}
