/**
 * Created by Shreyansh97 on 7/9/19
 */

public class Main {
  public static void main(String[] args) {
    Game game = Game.setupFromUser(System.in);
    String winner = game.play(System.out);
    System.out.println(winner + " wins the game");
  }
}
