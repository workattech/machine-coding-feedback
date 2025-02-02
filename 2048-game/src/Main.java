// import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(4,2, 10);
        Game game = new Game(board);
        game.startGame(board);
    }
}
