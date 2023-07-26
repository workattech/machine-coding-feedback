import com.entities.Board;
import com.entities.Ladder;
import com.entities.Player;
import com.entities.Snake;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int numberOfSnakes = Integer.parseInt(args[0]);
        int numberOfLadders = Integer.parseInt(args[numberOfSnakes + 1]);
        int numberOfPlayers = Integer.parseInt(args[numberOfSnakes + numberOfLadders + 2]);

        Board board = new Board();
        for (int i = 1; i <= numberOfSnakes; i++) {
            String[] snakePositions = args[i].split(" ");
            int head = Integer.parseInt(snakePositions[0]);
            int tail = Integer.parseInt(snakePositions[1]);
            board.addSnake(head, tail);
        }
        for (int i = numberOfSnakes + 2; i <= numberOfSnakes + numberOfLadders + 1; i++) {
            String[] ladderPositions = args[i].split(" ");
            int start = Integer.parseInt(ladderPositions[0]);
            int end = Integer.parseInt(ladderPositions[1]);
            board.addLadder(start, end);
        }

        for (int i = numberOfSnakes + numberOfLadders + 3; i < args.length; i++) {
            board.addPlayer(args[i]);
        }

        playGame(board);
    }

    private static void playGame(Board board) {
        List<Player> players = board.getPlayers();

        while (true) {
            for (Player player : players) {
                int diceValue = rollDice();
                int initialPosition = player.getPosition();
                int newPosition = initialPosition + diceValue;
                newPosition = applySnakesAndLadders(newPosition, board);

                if (newPosition <= 100) {
                    player.setPosition(newPosition);
                    System.out.println(player.getName() + " rolled a dice value=" + diceValue + " and moved from " +
                            initialPosition + " to " + newPosition);

                    if (newPosition == 100) {
                        System.out.println(player.getName() + " wins the game");
                        return;
                    }
                }
            }
        }
    }

    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static int applySnakesAndLadders(int position, Board board) {
        List<Snake> snakes = board.getSnakes();
        List<Ladder> ladders = board.getLadders();

        while (isSnakeHead(position, snakes) || isLadderStart(position, ladders)) {
            if (isSnakeHead(position, snakes)) {
                position = getSnakeTail(position, snakes);
            } else if (isLadderStart(position, ladders)) {
                position = getLadderEnd(position, ladders);
            }
        }
        return position;
    }

    private static boolean isSnakeHead(int position, List<Snake> snakes) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                return true;
            }
        }
        return false;
    }

    private static int getSnakeTail(int position, List<Snake> snakes) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                return snake.getTail();
            }
        }
        return position;
    }

    private static boolean isLadderStart(int position, List<Ladder> ladders) {
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                return true;
            }
        }
        return false;
    }

    private static int getLadderEnd(int position, List<Ladder> ladders) {
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                return ladder.getEnd();
            }
        }
        return position;
    }
}
