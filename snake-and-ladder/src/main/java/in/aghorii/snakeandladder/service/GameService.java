package in.aghorii.snakeandladder.service;

import in.aghorii.snakeandladder.model.Board;
import in.aghorii.snakeandladder.model.Ladder;
import in.aghorii.snakeandladder.model.Player;
import in.aghorii.snakeandladder.model.Snake;

import java.util.List;
import java.util.Random;

public class GameService {

    private final Board board;

    public GameService(Board board) {
        this.board = board;
    }

    public String startGameAndProvideWinner() {
        List<Player> players = board.getPlayers();
        return startGame(players);
    }

    private String startGame(List<Player> players) {

        int playerCount = players.size();
        int currentPlayerIndex = 0;
        boolean winnerFound = false;

        while(!winnerFound) {
            Player currentPlayer = players.get(currentPlayerIndex);
            int currentPosition = currentPlayer.getPosition();

            int diceNumber = rollDice();
            winnerFound = executeTurn(currentPlayer, diceNumber);

            System.out.println(currentPlayer.getName() + " rolled a " + diceNumber + " and moved from "
                    + currentPosition + " to " + currentPlayer.getPosition());

            if (!winnerFound) {
                currentPlayerIndex++;
                if(currentPlayerIndex == playerCount) {
                    currentPlayerIndex = 0;
                }
            }
        }

        return players.get(currentPlayerIndex).getName();
    }

    private boolean executeTurn(Player player, int diceNumber) {
        if ((player.getPosition() + diceNumber) > board.getBoardSize()) {
            return false;
        }
        player.setPosition(player.getPosition() + diceNumber);

        if (player.getPosition() == board.getBoardSize()) {
            return true;
        }
        checkForSnakeOrLadder(player);

        return player.getPosition() == board.getBoardSize();
    }

    private void checkForSnakeOrLadder(Player player) {
        for (Snake snake : board.getSnakes()) {
            if (player.getPosition() == snake.getHead()) {
                player.setPosition(snake.getTail());
                checkForSnakeOrLadder(player);
            }
        }

        for (Ladder ladder : board.getLadders()) {
            if (player.getPosition() == ladder.getStart()) {
                player.setPosition(ladder.getEnd());
                checkForSnakeOrLadder(player);
            }
        }
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
