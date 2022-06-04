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

    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Board board;
    private Dice dice;

    public Game(List<Snake> snakes, List<Ladder> ladders, int boardSize) {
        this.players = new ArrayDeque<>();
        this.snakes = snakes;
        this.ladders = ladders;
        dice = new Dice(1, 6, 2);
        board = new Board(boardSize);
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

    /*
    logic implemented in case we want to generate a random set of snakes and ladders then this can be utilise
    instead of taking input from user
     */
//    public void setSnakesAndLaddersForBoard() {
//        System.out.println("Initialising game board");
//        Set<String> snakesLaddersSet = new HashSet<>();
//        for (int index = 0; index < numOfSnakes; ++index) {
//            while (true) {
//                int snakeHeadRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
//                int snakeTailRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
//                if (snakeTailRandom >= snakeHeadRandom)
//                    continue;
//                String snakeStartEndPair = String.valueOf(snakeHeadRandom) + snakeTailRandom;
//                if (!snakesLaddersSet.contains(snakeStartEndPair)) {
//                    Snake snake = new Snake(snakeHeadRandom, snakeTailRandom);
//                    snakes.add(snake);
//                    snakesLaddersSet.add(snakeStartEndPair);
//                    break;
//                }
//            }
//        }
//
//        for (int index = 0; index < numOfLadders; ++index) {
//            while (true) {
//                int ladderHeadRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
//                int ladderTailRandom = (int) (Math.random() * (board.getEndBoardIndex())) + board.getStartBoardIndex();
//                if (ladderTailRandom <= ladderHeadRandom)
//                    continue;
//                String ladderStartEndPair = String.valueOf(ladderHeadRandom) + ladderTailRandom;
//                if (!snakesLaddersSet.contains(ladderStartEndPair)) {
//                    Ladder ladder = new Ladder(ladderHeadRandom, ladderTailRandom);
//                    ladders.add(ladder);
//                    snakesLaddersSet.add(ladderStartEndPair);
//                    break;
//                }
//            }
//        }
//        System.out.println("Snakes and ladders in the game are as follows");
//        for (Snake gameSnake : snakes) {
//            System.out.printf("Snake head at %d, and tail at %d\n", gameSnake.getSnakeHead(), gameSnake.getSnakeTail());
//        }
//
//        for (Ladder gameLadder : ladders) {
//            System.out.printf("Ladder head at %d, and tail at %d\n", gameLadder.getLadderHead(), gameLadder.getLadderTail());
//        }
//    }

    public void printSnakesAndLaddersForBoard() {
        System.out.println("*****Snakes and ladders in the game are as follows*****");
        for (Snake gameSnake : snakes) {
            System.out.printf("Snake head at %d, and tail at %d\n", gameSnake.getSnakeHead(), gameSnake.getSnakeTail());
        }

        for (Ladder gameLadder : ladders) {
            System.out.printf("Ladder head at %d, and tail at %d\n", gameLadder.getLadderHead(), gameLadder.getLadderTail());
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playSnakeLadderGame() {
        System.out.println("*****Game Begins*****");
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
                currentPlayer.setPosition(getCurrentPlayerNewPosition(newPosition, previousPosition, diceVal, currentPlayer));
                if (currentPlayer.getPosition() == board.getEndBoardIndex()) {
                    currentPlayer.setGame_status(true);
                    System.out.printf("%s wins the game\n", currentPlayer.getName());
                } else {
//                    System.out.printf("%s rolled a %d and moved from %d to %d\n", currentPlayer.getName(), diceVal, previousPosition, currentPlayer.getPosition());
                    players.offer(currentPlayer);
                }
            }
            if (players.size() < 2) {
                playGame = false;
            }
        }
    }


    public int getCurrentPlayerNewPosition(int newPosition, int previousPosition, int diceVal, Player currentPlayer) {
        for (Snake snake : snakes) {
            if (snake.getSnakeHead() == newPosition) {
                System.out.printf("%s rolled a %d and Snake bit %s at %d, %s moved from %d to %d\n",
                        currentPlayer.getName(), diceVal, currentPlayer.getName(), newPosition,
                        currentPlayer.getName(), newPosition, snake.getSnakeTail());
                return snake.getSnakeTail();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getLadderHead() == newPosition) {
                System.out.printf("%s rolled a %d, Ladder found at position %d, %s moved from %d to %d\n",
                        currentPlayer.getName(), diceVal, newPosition, currentPlayer.getName(), newPosition, ladder.getLadderTail());
                return ladder.getLadderTail();
            }
        }
        System.out.printf("%s rolled a %d and moved from %d to %d\n", currentPlayer.getName(), diceVal,
                previousPosition, newPosition);
        return newPosition;
    }
}
