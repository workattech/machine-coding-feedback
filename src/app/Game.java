/**
 * Game
 */
package app;
public class Game {
    public static void main(String[] args) {
        BoardGame game = new BoardGame();
        game.prepare();
        game.play();
    }
}