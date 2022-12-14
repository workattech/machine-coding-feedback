import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SnakeAndLadderBoard board;
        SnakeAndLadderService game;

        int numberOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i = 0; i < numberOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        int numberOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < numberOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        int numberOfUsers = scanner.nextInt();
        List<User> users =  new ArrayList<>();
        for(int i=0; i < numberOfUsers; i++) {
            users.add(new User(scanner.next(), 0));
        }

        board = new SnakeAndLadderBoard(snakes, ladders);
        game = new SnakeAndLadderService(board, users);
        game.run();
    }
}