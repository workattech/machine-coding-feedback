import Dto.GameDTO;
import InputReader.InputReaderFromFile;
import OutputWriter.OutputWriter;
import models.Dice;
import models.Game;
import models.Player;
import services.DiceService;
import services.GameService;
import services.PlayerService;

import java.io.IOException;

public class SnakeLadderGameApp {
    public static void main(String[] args) throws IOException {
        final String inputFile = "src/input.txt";
        final InputReaderFromFile inputReaderFromFile = new InputReaderFromFile(inputFile);
        final OutputWriter outputWriter = new OutputWriter();
        final DiceService diceService = new DiceService(new Dice(6));
        final PlayerService playerService = new PlayerService(outputWriter, diceService);
        final GameService gameService = new GameService(new Game(inputReaderFromFile.readGameInput()), playerService, outputWriter);

        gameService.runGame();

    }
}