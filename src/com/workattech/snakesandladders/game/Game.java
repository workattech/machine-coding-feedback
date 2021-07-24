package com.workattech.snakesandladders.game;

import java.util.*;

public class Game {

    /**
     * game class , which takes care of initializing all the components of snake, ladder game
     * Here we take number of snakes and ladders as inputs and create a list out of it so that we can maintain
     * the list to be used while playing the game
     * Also we initialize the board with the size provided,
     * along with the dice min, max value and initial face value of dice
     */

    private int numOfSnakes;
    private int numOfLadders;

    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Board board;
    private Dice dice;

    public Game(int numOfSnakes, int numOfLadders, int boardSize) {
        this.numOfSnakes = numOfSnakes;
        this.numOfLadders = numOfLadders;
        this.players = new ArrayDeque<>();
        snakes = new ArrayList<>(numOfSnakes);
        ladders = new ArrayList<>(numOfLadders);
        dice = new Dice(1, 6, 2);
        board = new Board(boardSize);
    }

    public int getNumOfSnakes() {
        return numOfSnakes;
    }

    public int getNumOfLadders() {
        return numOfLadders;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public void setSnakesAndLaddersForBoard() {
        Set<String> snakesLaddersSet = new HashSet<>();
        for (int index = 0; index < numOfSnakes; ++index) {
            while (true) {
                int snakeHeadRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
                int snakeTailRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getEndBoardIndex();
                if (snakeTailRandom >= snakeHeadRandom)
                    continue;
                String snakeStartEndPair = String.valueOf(snakeHeadRandom) + snakeTailRandom;
                if (!snakesLaddersSet.contains(snakeStartEndPair)) {
                    Snake snake = new Snake(snakeHeadRandom, snakeTailRandom);
                    snakes.add(snake);
                    snakesLaddersSet.add(snakeStartEndPair);
                    break;
                }
            }
        }

        for (int index = 0; index < numOfLadders; ++index) {
            while (true) {
                int ladderHeadRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
                int ladderTailRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getEndBoardIndex();
                if (ladderTailRandom <= ladderHeadRandom)
                    continue;
                String ladderStartEndPair = String.valueOf(ladderHeadRandom) + ladderTailRandom;
                if (!snakesLaddersSet.contains(ladderStartEndPair)) {
                    Ladder ladder = new Ladder(ladderHeadRandom, ladderTailRandom);
                    ladders.add(ladder);
                    snakesLaddersSet.add(ladderStartEndPair);
                    break;
                }
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playSnakeLadderGame() {
        boolean playGame = true;
        while (playGame) {
            Player currentPlayer = players.poll();
            int diceVal = dice.rollDice();
            int previousPosition = currentPlayer.getPosition();
            int newPosition = previousPosition + diceVal;
            if (newPosition > board.getEndBoardIndex()) {
                currentPlayer.setPosition(previousPosition);
                players.offer(currentPlayer);
            } else {
                currentPlayer.setPosition(getCurrentPlayerNewPosition(newPosition, currentPlayer));
                if (currentPlayer.getPosition() == board.getEndBoardIndex()) {
                    currentPlayer.setGame_status(true);
                    System.out.printf("%s wins the game", currentPlayer.getName());
                } else {
                    System.out.printf("%s rolled a %d and moved from %d to %d", currentPlayer.getName(), diceVal, previousPosition, currentPlayer.getPosition());
                    players.offer(currentPlayer);
                }
            }
            if (players.size() < 2) {
                playGame = false;
            }
        }
    }


    public int getCurrentPlayerNewPosition(int newPosition, Player currentPlayer) {
        for (Snake snake : snakes) {
            if (snake.getSnakeHead() == newPosition) {
                System.out.printf("Snake bit %s at %d\n", currentPlayer.getName(), newPosition);
                return snake.getSnakeTail();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getLadderHead() == newPosition) {
                System.out.printf("Ladder found at position %d, %s moving up the ladder", newPosition, currentPlayer.getName());
                return ladder.getLadderTail();
            }
        }

        return newPosition;
    }
}
