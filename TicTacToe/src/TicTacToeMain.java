import exception.InvalidMove;
import model.Player;
import service.GridService;
import service.InputService;

import java.io.IOException;

public class TicTacToeMain {
    public static void main(String[] args) {
        InputService inputService = new InputService();

        int numberOfPlayers = 2;
        Player[] players = new Player[numberOfPlayers];

        try {
            for (int n = 0; n < numberOfPlayers; n++) {
                String[] player = inputService.readInputs().split(" ");
                players[n] = new Player(player[1], player[0].charAt(0));
            }

            GridService gridService = new GridService();
            int rows = 3, cols = 3;
            gridService.initializeGrid(rows, cols, players);

            String command = inputService.readInputs();
            while (!command.equals("exit")) {
                String[] moves = command.split(" ");
                try {
                    boolean isValid = gridService.makeAMove(Integer.valueOf(moves[0]), Integer.valueOf(moves[1]));
                    if (isValid) {
                        System.exit(0);
                    }
                } catch (InvalidMove invalidMove) {
                    System.out.println(invalidMove.getMessage());
                }
                command = inputService.readInputs();
            }
            System.out.println("Game Over");
        } catch (IOException ioException) {
            System.out.println("Error reading from command line");
            throw new RuntimeException(ioException);
        }
    }
}