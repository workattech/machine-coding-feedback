package snakeandladder;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Board setup
        Board board = new Board(100);
        System.out.print("Enter the number of snakes: ");
        int numSnakes = scanner.nextInt();
        System.out.println("Enter the snake heads and tails:");
        for (int i = 0; i < numSnakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            board.addSnake(head, tail);
        }

        System.out.print("Enter the number of ladders: ");
        int numLadders = scanner.nextInt();
        System.out.println("Enter the ladder starts and ends:");
        for (int i = 0; i < numLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.addLadder(start, end);
        }

        // Player setup
        Queue<Player> players = new LinkedList<>();
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter player names:");
        for (int i = 0; i < numPlayers; i++) {
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // Initialize game components
        Dice dice = new Dice();
        Game game = new Game(board, dice, players);

        // Start game
        System.out.println("\nGame started!");
        game.play();
    }
}
