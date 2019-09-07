import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shreyansh97 on 7/9/19
 */

public class Game {
  private List<Player> players;
  private Board board;
  private Dice dice;
  
  private Game(int boardSize, int diceCount) {
    board = new Board(boardSize);
    dice = new Dice(diceCount);
    players = new ArrayList<>();
  }
  
  public static Game setupFromUser(InputStream in) {
    Scanner scanner = new Scanner(in);
    
    // creating board with 100 places and 1 dice
    Game game = new Game(100, 1);
    
    // adding snakes
    int s = scanner.nextInt();
    while (s-- > 0) {
      int head = scanner.nextInt();
      int tail = scanner.nextInt();
      game.board.addSnake(head, tail);
    }
    
    // adding ladders
    int l = scanner.nextInt();
    while (l-- > 0) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      game.board.addLadder(start, end);
    }
    
    //adding players
    int p = scanner.nextInt();
    scanner.nextLine();
    while (p-- > 0) {
      Player player = new Player(scanner.nextLine());
      game.players.add(player);
    }
    
    return game;
  }
  
  public void play(PrintStream out) {
    int left = players.size() - 1;
    while (true) {
      for (Player player : players) {
        if (player.hasWon()) {
          continue;
        }
        int initialPosition = player.getPosition();
        int shifts = dice.roll();
        int finalPosition = board.getPositionAfterMove(initialPosition, shifts);
        player.setPosition(finalPosition);
        out.printf("%s rolled a %d and moved from %d to %d\n", player.getName(), shifts, initialPosition,
                   finalPosition);
        if (finalPosition == board.getSize()) {
          System.out.println(player.getName() + " wins the game");
          player.setWon();
          left--;
          if (left == 0) {
            return;
          }
        }
      }
    }
  }
  
}
