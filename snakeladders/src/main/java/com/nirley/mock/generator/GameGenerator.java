package com.nirley.mock.generator;

import com.nirley.mock.game.Game;
import com.nirley.mock.game.config.GameConfig;
import com.nirley.mock.player.Player;

import java.util.List;

public class GameGenerator {

    public static Game generateGame(GameConfig gameConfig, List<Player> playerList) {
        Game game = new Game(gameConfig, playerList);
        return game;
    }
}
