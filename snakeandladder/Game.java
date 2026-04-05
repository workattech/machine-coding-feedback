package snakeandladder;


import java.util.Queue;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;

    public Game(Board board, Dice dice, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public void play() {
        boolean gameWon = false;
        while (!gameWon) {
            Player currentPlayer = players.poll();
            int initialPosition = currentPlayer.getPosition();
            int diceValue = dice.roll();
            int newPosition = initialPosition + diceValue;

            // Check for board limits
            if (newPosition <= board.getSize()) {
                newPosition = board.getNextPosition(newPosition);
                currentPlayer.setPosition(newPosition);
            }

            System.out.printf("%s rolled a %d and moved from %d to %d%n",
                    currentPlayer.getName(), diceValue, initialPosition, currentPlayer.getPosition());

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.printf("%s wins the game%n", currentPlayer.getName());
                gameWon = true;
            } else {
                players.add(currentPlayer);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.insert(0,"abc");
    }
}
