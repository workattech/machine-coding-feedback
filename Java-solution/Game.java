import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
  private List<Player> players;
  private Board board;
  private Player winner;
  private Random random;

  public Game(Board board) {
    this.players = new ArrayList<>();
    this.board = board;
    this.winner = null;
    this.random = new Random();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void setSnakes(List<int[]> snakes) {
    for (int[] snake : snakes) {
      board.addSnake(snake[0], snake[1]);
    }
  }

  public void setLadders(List<int[]> ladders) {
    for (int[] ladder : ladders) {
      board.addSnake(ladder[0], ladder[1]);
    }
  }

  public int rollDice() {
    return random.nextInt(6) + 1;
  }

  public void play() {
    int currentPlayerIndex = 0;
    while (winner == null) {
      Player player = players.get(currentPlayerIndex);
      int diceValue = rollDice();
      int initialPosition = player.getPosition();
      int newPosition = initialPosition + diceValue;

      if (newPosition <= board.getSize()) {
        newPosition = board.getNewPosition(newPosition);
        player.setPosition(newPosition);
      }

      System.out.printf("%s rolled a %d and moved from %d to %d%n", player, diceValue, initialPosition,
          player.getPosition());

      if (player.getPosition() == board.getSize()) {
        winner = player;
        System.out.printf("%s wins the game.%n", player);
        break;
      }

      currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
  }
}
