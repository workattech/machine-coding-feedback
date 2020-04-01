package logic;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SnLGame {

    Die die;
    Board board;
    List<Snake> snakes;
    List<Ladder> ladders;
    List<Player> players;
    boolean gameOver;

    public SnLGame(Map<Integer, Integer> snakesMap, Map<Integer, Integer> laddersMap, List<String> playerNames) {
        die = new Die();
        snakes = new ArrayList<>();
        createSnakesList(snakesMap);
        ladders = new ArrayList<>();
        createLaddersList(laddersMap);
        board = new Board(snakes, ladders);
        players = new ArrayList<>();
        createPlayersList(playerNames);
        startGame();
    }

    public SnLGame(int size, Map<Integer, Integer> snakesMap, Map<Integer, Integer> laddersMap, List<String> playerNames) {
        die = new Die();
        snakes = new ArrayList<>();
        createSnakesList(snakesMap);
        ladders = new ArrayList<>();
        createLaddersList(laddersMap);
        board = new Board(size, snakes, ladders);
        players = new ArrayList<>();
        createPlayersList(playerNames);
        startGame();
    }

    private void createSnakesList(Map<Integer, Integer> snakesMap) {
        for (Map.Entry<Integer, Integer> entry : snakesMap.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            snakes.add(new Snake(start, end));
        }
    }

    private void createLaddersList(Map<Integer, Integer> laddersMap) {
        for (Map.Entry<Integer, Integer> entry : laddersMap.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            ladders.add(new Ladder(start, end));
        }
    }

    private void createPlayersList(List<String> playerNames) {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    private void startGame() {
        while (!isGameOver()) {
            for (Player player : players) {
                if (isGameOver()) break;
                playTurn(player);
            }
        }
    }

    private void playTurn(Player player) {
        int currentPos = player.getCurrentPosition();
        int rolledValue = rollDice();
        int newPos = currentPos + rolledValue;
        if (newPos > board.getSize()) {
            return;
        } else if (newPos < board.getSize()) {
            movePlayer(player, rolledValue, currentPos, newPos);
        } else {
            movePlayer(player, rolledValue, currentPos, newPos);
            playerHasWon(player);
        }
    }

    private int rollDice() {
        int rolledValue = die.rollDie();
        return rolledValue;
    }

    private void movePlayer(Player player, int rolledValue, int currentPos, int newPos) {
        newPos = checkForLadderAndSnake(newPos);
        printMovement(player.getName(), rolledValue, currentPos, newPos);
        player.setCurrentPosition(newPos);
    }

    private int checkForLadderAndSnake(int position) {
        int currentPos = position;
        while (board.cellHasSnakeOrLadder(currentPos)) {
            if (board.cellHasSnake(currentPos)) {
                currentPos = board.getEndOfSnake(currentPos);
            }
            if (board.cellHasLadder(currentPos)) {
                currentPos = board.getEndOfLadder(currentPos);
            }
        }
        return currentPos;
    }

    private void printMovement(String playerName, int rolledValue, int currentPos, int newPos) {
        System.out.println(playerName + " rolled a " + rolledValue + " and moved from " + currentPos + " to " + newPos);
    }

    private void playerHasWon(Player player) {
        printWinningMessage(player.getName());
        gameOver = true;
    }

    private void printWinningMessage(String playerName) {
        System.out.println(playerName + " wins the game");
    }

    private boolean isGameOver() {
        return gameOver;
    }

}
