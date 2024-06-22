import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int s = scanner.nextInt();
    List<int[]> snakes = new ArrayList<>();
    for (int i = 0; i < s; i++) {
      int head = scanner.nextInt();
      int tail = scanner.nextInt();
      snakes.add(new int[] { head, tail });
    }

    int l = scanner.nextInt();
    List<int[]> ladders = new ArrayList<>();
    for (int i = 0; i < l; i++) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      ladders.add(new int[] { start, end });
    }

    int p = scanner.nextInt();
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < p; i++) {
      String name = scanner.next();
      players.add(new Player(name));
    }

    scanner.close();

    Board board = new Board(100);
    Game game = new Game(board);
    game.setSnakes(snakes);
    game.setLadders(ladders);
    for (Player player : players) {
      game.addPlayer(player);
    }

    game.play();
  }
}
