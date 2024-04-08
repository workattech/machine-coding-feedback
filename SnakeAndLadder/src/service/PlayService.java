package service;

import models.Board;
import models.Player;

import java.util.Random;

public class PlayService {
    Board board;

    public PlayService(Board board) {
        this.board = board;
    }

    public void playMatch() {
        int players = board.getPlayer().length;

        while (!board.isDone()) {
            for (int i = 0; i < players; i++) {
                int diceNumber = rollDice();
                Player player = board.getPlayer()[i];
                int newPosition = getNewPosition(player, diceNumber);
                if (newPosition > board.getNumberOfCells()) {
                    System.out.println("Invalid move " + player.getName() + " stays in the same position");
                    continue;
                }
                System.out.println(player.getName() + " rolled a " + diceNumber + " and moved from " +
                        player.getCurrentCell() + " to " + newPosition);
                player.setCurrentCell(newPosition);
                if (newPosition == board.getNumberOfCells()) {
                    System.out.println(player.getName());
                    board.setDone(true);
                    return;
                }
            }
        }
    }

    public int getNewPosition(Player player, int diceNumber) {

        int playersCurrPosition = player.getCurrentCell();
        int newPosition = playersCurrPosition + diceNumber;

        int snakes = board.getSnakes().getSnakePositions().getOrDefault(newPosition, -1);
        if (snakes != -1) {
            return snakes;
        }
        int ladder = board.getLadders().getLadderPositions().getOrDefault(newPosition, -1);
        if (ladder != -1) {
            return ladder;
        }

        return newPosition;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(board.getDice()) + 1;
    }
}
