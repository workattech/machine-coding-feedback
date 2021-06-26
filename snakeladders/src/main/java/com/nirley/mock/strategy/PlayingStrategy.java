package com.nirley.mock.strategy;

import com.nirley.mock.game.Game;
import com.nirley.mock.player.Player;
import com.nirley.mock.player.PlayerKey;

public interface PlayingStrategy {

    boolean playNext(Game game, int diceMove, PlayerKey playerKey);

    boolean isPlayerWinner(Game game, Player player);

}
