package InputReader;

import Dto.GameDTO;
import models.Obstacles;
import models.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputReaderFromFile {
    final String fileName;

    public InputReaderFromFile(String fileName) {
        this.fileName = fileName;
    }

    public GameDTO readGameInput() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringTokenizer st;

        List<Player> players = new ArrayList<>();
        List<Obstacles> obstacles = new ArrayList<>();

        int SnakeCount = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i < SnakeCount; i++) {
            st = new StringTokenizer(reader.readLine().trim());
            int startPosition = Integer.parseInt(st.nextToken());
            int endPosition = Integer.parseInt(st.nextToken());
            obstacles.add(new Obstacles(startPosition, endPosition));
        }

        int LadderCount = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i < LadderCount; i++) {
            st = new StringTokenizer(reader.readLine().trim(), " ");
            int startPosition = Integer.parseInt(st.nextToken());
            int endPosition = Integer.parseInt(st.nextToken());
            obstacles.add(new Obstacles(startPosition, endPosition));
        }

        int PlayerCount = Integer.parseInt(reader.readLine().trim());
        for(int i = 0; i < PlayerCount; i++) {
            String playerName = reader.readLine().trim();
            players.add(new Player(playerName));
        }
        reader.close();

        return new GameDTO(players, obstacles);
    }

}
