import business.Game;
import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<String> snakesInput = new ArrayList<String>(Arrays.asList(
                "62 5"
                ,"33 6"
                ,"49 9"
                ,"88 16"
                ,"41 20"
                ,"56 53"
                ,"98 64"
                ,"93 73"
                ,"95 75" ));
        List<String> laddersInput = new ArrayList<>(Arrays.asList(
                "2 37"
                ,"27 46"
                ,"10 32"
                ,"51 68"
                ,"61 79"
                ,"65 84"
                ,"71 91"
                ,"81 100" ));
        List<String> playersInput = new ArrayList<>(Arrays.asList(
                "Gaurav"
                ,"Sagar"));
        Game game = null;
        try {
            List<Snake> snakes = new ArrayList<>();
            for (String snakeInput: snakesInput
            ) {
                String[] headtail = snakeInput.split(" ");
                snakes.add(new Snake(Integer.parseInt(headtail[0]), Integer.parseInt(headtail[1])));
            }

            List<Ladder> ladders = new ArrayList<>();
            for (String ladderInput :
                    laddersInput) {
                String[] startend = ladderInput.split(" ");
                ladders.add(new Ladder(Integer.parseInt(startend[0]),Integer.parseInt(startend[1])));
            }
            List<Player> players = new ArrayList<>();
            for (String name :
                    playersInput) {
                players.add(new Player(name));
            }

            game = new Game(new Board(100, ladders, snakes),players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        do {
            game.makeMove();
        } while (!game.isOver());

    }
}
