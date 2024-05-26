package in.aghorii.snakeandladder;

import in.aghorii.snakeandladder.model.*;
import in.aghorii.snakeandladder.service.GameService;
import in.aghorii.snakeandladder.service.creator.BoardCreator;
import in.aghorii.snakeandladder.util.PropertyInjector;
import in.aghorii.snakeandladder.util.PropertyLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameExecutor {
    private static final List<Snake> snakes = new ArrayList<>();
    private static final List<Ladder> ladders = new ArrayList<>();
    private static final List<Player> players = new ArrayList<>();

    public GameExecutor() {}

    public static void execute() {
        Board board = injectPropertyAndCreateBoard();
        GameService gameService = new GameService(board);
        String winner = gameService.startGameAndProvideWinner();

        System.out.println(winner + " wins the game\n");
    }

    private static Board injectPropertyAndCreateBoard() {
        BoardCreator boardCreator = getBoardCreator();
        extractGameElements();

        return boardCreator.createBoard(snakes, ladders, players);
    }

    private static BoardCreator getBoardCreator() {
        BoardCreator boardCreator = new BoardCreator();
        PropertyLoader propertyLoader = new PropertyLoader("config.properties");
        PropertyInjector injector = new PropertyInjector(propertyLoader);
        injector.inject(boardCreator);

        return boardCreator;
    }

    private static void extractGameElements() {

        try (InputStream inputStream = GameExecutor.class.getClassLoader().getResourceAsStream("snake&ladder.txt")) {
            if (inputStream == null) {
                System.out.println("Could not find snake&ladder.txt file");
                throw new RuntimeException("Could not find snake&ladder.txt file");
            }

            processFile(inputStream);
        } catch (IOException ex) {
            System.out.println("Could not read snake&ladder.txt file");
            throw new RuntimeException("Could not read snake&ladder.txt file");
        }
    }

    private static void processFile(InputStream inputStream) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            //Populate snakes
            line = reader.readLine();
            int n = Integer.parseInt(line);
            for(int i=0; i<n; i++) {
                line = reader.readLine();
                String[] split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                snakes.add(new Snake(x, y));
            }

            //Populate ladders
            line = reader.readLine();
            int m = Integer.parseInt(line);
            for(int i=0; i<m; i++) {
                line = reader.readLine();
                String[] split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                ladders.add(new Ladder(x, y));
            }

            //Populate players
            line = reader.readLine();
            int q = Integer.parseInt(line);
            for(int i=0; i<q; i++) {
                line = reader.readLine();

                players.add(new Player(line));
            }

        } catch (IOException ex) {
            System.out.println("Could not read snake&ladder.txt file");
            throw new RuntimeException("Could not read snake&ladder.txt file");
        }
    }
}
