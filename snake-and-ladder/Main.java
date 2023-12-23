import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    // Main is the test class.
    // It will call another class SnakeAndLadder which would actually run the game,
    // given Board, Snakes, Ladders, Players and Dices to use.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x, y;
        n = scanner.nextInt();
        List<Position> positions = new ArrayList<Position>(n);
        for (int i = 0; i < n; ++i) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            positions.add(i, new Position(x, y));
        }
        Entities snakes = new Snakes(positions);
        n = scanner.nextInt();
        positions = new ArrayList<Position>(n);
        for (int i = 0; i < n; ++i) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            positions.add(i, new Position(x, y));
        }
        Ladders ladders = new Ladders(positions);
        n = scanner.nextInt();
        List<Player> players = new ArrayList<Player>(n);
        String name;
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            name = scanner.nextLine();
            players.add(i, new Player(name, 0));
        }
        new Board(100, snakes, ladders, new Dices(1), players).run();
    }
}