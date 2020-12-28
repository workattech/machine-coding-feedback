package business;

import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

import javax.swing.plaf.metal.MetalBorders;
import java.util.List;
import java.util.Random;

public class Game {
    private Board board;
    private List<Player> players;
    private int[] positions;
    private int index = -1;
    private boolean isGameOver;
    private Player winner;


    public Game(Board board, List<Player> players) {
        // TODO verification
        this.board = board;
        this.players = players;
        positions = new int[players.size()];
    }

    public void makeMove() {
        if(isGameOver) {
            System.out.println("Game is over. Move not allowed.");
            return;
        }
        Player player = getTurn();
        int steps = roll();
        int currentPosition = positions[players.indexOf(player)];
        int newPosition = getNewPosition(currentPosition, steps);
        positions[players.indexOf(player)] = newPosition;
        System.out.printf("%s rolled a %s and moved from %s to %s \n",
                player.getName(), steps, currentPosition, newPosition);
        if (newPosition == board.getSize()) {
            isGameOver = true;
            winner = player;
            return;
        }
        setNextTurn();
    }

    private int getNewPosition(int currentPosition, int steps) {
        int newPosition = currentPosition + steps;
        boolean validCell = board.isValidCell(newPosition);
        if(!validCell) { return currentPosition;}

        do {
            Snake snake = board.getSnake(newPosition);
            Ladder ladder = board.getLadder(newPosition);
            if (ladder == null && snake == null) {
                break;
            }
            if(snake != null) { newPosition = snake.getTail();}
            if(ladder != null) { newPosition = ladder.getEnd();}
        } while(true);
        return newPosition;
    }

    private int roll() {
        Random rand = new Random();
        return rand.nextInt(5)+1;
    }
    private Player getTurn() {
        if(index == -1) {
            index = 0;
        }
        return players.get(index);
    }

    private Player setNextTurn() {
        index = (index+1)%2;
        return players.get(index);
    }

    public boolean isOver() {
        return isGameOver;
    }
}
