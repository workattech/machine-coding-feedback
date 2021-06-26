package com.nirley.mock;

import com.nirley.mock.dice.Dice;
import com.nirley.mock.dice.RandomDiceMover;
import com.nirley.mock.game.Game;
import com.nirley.mock.game.config.GameConfig;
import com.nirley.mock.generator.GameGenerator;
import com.nirley.mock.player.Player;
import com.nirley.mock.player.PlayerKey;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverMain {

    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap();
        snakes.put(62, 5);
        snakes.put(33, 6);
        snakes.put(49, 9);
        snakes.put(88, 16);
        snakes.put(41, 20);
        snakes.put(56, 53);
        snakes.put(98, 64);
        snakes.put(93, 73);
        snakes.put(95, 75);

        Map<Integer, Integer> ladders = new HashMap();
        ladders.put(2, 37);
        ladders.put(27, 46);
        ladders.put(10, 32);
        ladders.put(51, 68);
        ladders.put(61, 79);
        ladders.put(65, 84);
        ladders.put(71, 91);
        ladders.put(81, 100);

        Dice dice = new Dice(1, 6, new RandomDiceMover(1, 6));
        GameConfig config = new GameConfig(100, 0, snakes, ladders, Arrays.asList(dice));

        Player firstPlayer = new Player(new PlayerKey(1), "Gaurav");
        Player secondPlayer = new Player(new PlayerKey(2), "Sagar");

        Game snakeLadderGame = GameGenerator.generateGame(config, Arrays.asList(firstPlayer, secondPlayer));


        while (!snakeLadderGame.isComplete()) {
            for (Player player : snakeLadderGame.getPlayers().values()) {
                snakeLadderGame.playNext(player.getPlayerKey());
                if (snakeLadderGame.isComplete()) break;
            }
        }

    }
}
