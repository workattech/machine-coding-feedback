import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int dices;
    private final Board board;
    private final List<Player> playersList;

    private final Dice dice;
    private static int snakes;
    private static int ladders;
    private Game(int rows,int columns,int dices) {
      playersList = new ArrayList<>();
      board = new Board(rows,columns);
      this.dices = dices;
      dice = new Dice(1,6);
    }

    private static Game game;
    public static Game getInstance(int rows,int columns,int dices) {
      if(game == null)
          game = new Game(rows,columns,dices);
      return game;
    }

    public static int getSnakes() {
        return snakes;
    }

    public static void setSnakes(int snakes) {
        Game.snakes = snakes;
    }

    public static int getLadders() {
        return ladders;
    }

    public static void setLadders(int ladders) {
        Game.ladders = ladders;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public Board getBoard() {
        return board;
    }

    public void start() {
        System.out.println("\n----------Starting game---------------\n");
        board.display();
        GameUtil.start(playersList,dices,dice,board);
    }
}
