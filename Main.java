import service.GamePlay;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;

public class Main {

    private static GamePlay gamePlay;

    public static void main(String[] args) throws IOException {

        int snakes=0, ladders=0, players=0;
        List<List<Integer>> snakesList = new ArrayList<>();
        List<List<Integer>> laddersList = new ArrayList<>();
        List<String> playersList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        try {
            StringBuilder sb = new StringBuilder();

            //read snakes positions
            String line = br.readLine();
            if(line != null) {
                snakes = Integer.parseInt(line);
                for(int i=0; i<snakes; i++) {
                    line = br.readLine();
                    if(line != null) {
                        String[] tokens = line.split(" ");
                        int start = Integer.parseInt(tokens[0]);
                        int end = Integer.parseInt(tokens[1]);
                        snakesList.add(Arrays.asList(start, end));
                    }
                }
            }

            //read ladders positions
            line = br.readLine();
            if(line != null) {
                ladders = Integer.parseInt(line);
                for(int i=0; i<ladders; i++) {
                    line = br.readLine();
                    if(line != null) {
                        String[] tokens = line.split(" ");
                        int start = Integer.parseInt(tokens[0]);
                        int end = Integer.parseInt(tokens[1]);
                        laddersList.add(Arrays.asList(start, end));
                    }
                }
            }

            //read players
            line = br.readLine();
            if(line != null) {
                players = Integer.parseInt(line);
                for(int i=0; i<players; i++) {
                    line = br.readLine();
                    if(line != null) {
                        playersList.add(line);
                    }
                }
            }
        } finally {
            br.close();
        }

        gamePlay = new GamePlay(ladders, snakes, players, laddersList, snakesList, playersList);
        gamePlay.play();
    }
}
