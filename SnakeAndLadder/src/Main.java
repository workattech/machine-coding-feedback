import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Optional requirement 5 => instead of using command line
    // the start and end values can be generated using random functions.
    // by specifying the min and max values accordingly
    public static List<Snake> generateSnakes() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the number of snakes: ");
        int numSnakes = sc.nextInt();

        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < numSnakes; i++) {
            String values[] = sc.next().split(" ");
            int start = Integer.valueOf(values[0]);
            int end = Integer.valueOf(values[1]);
            snakes.add(new Snake(start, end));
        }

        return snakes;
    }

    public static List<Ladder> generateLadders() {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the number of ladders: ");
        int numLadders = sc.nextInt();

        List<Ladder> ladders = new ArrayList<>();

        for (int i = 0; i < numLadders; i++) {
            String values[] = sc.next().split(" ");
            int start = Integer.valueOf(values[0]);
            int end = Integer.valueOf(values[1]);
            ladders.add(new Ladder(start, end));
        }

        return ladders;
    }

    public static List<Player> generatePlayer() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the number of players: ");
        int numPlayers = sc.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            String name = sc.next();
            players.add(new Player(name, 0));
        }
        return players;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the size of the board: ");
        int boardSize = sc.nextInt();
        Board board = new Board(boardSize, generateSnakes(), generateLadders(), generatePlayer());

        while (true) {
            for (Player player : board.getPlayers()) {
                    board.updatePlayerOnBoard(player);
                    if (board.checkIfWon().isStatus()) {
                        Player winningPlayer = (Player) board.checkIfWon().getResponse();
                        System.out.println(winningPlayer.getName() + " Won the Game ");
                        return;
                    }
            }
        }

    }
}
