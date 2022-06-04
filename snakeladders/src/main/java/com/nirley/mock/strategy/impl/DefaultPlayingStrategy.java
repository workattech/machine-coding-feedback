package com.nirley.mock.strategy.impl;

import com.nirley.mock.game.Game;
import com.nirley.mock.game.config.GameConfig;
import com.nirley.mock.player.Player;
import com.nirley.mock.player.PlayerKey;
import com.nirley.mock.strategy.PlayingStrategy;

import java.util.Map;
import java.util.Optional;

public class DefaultPlayingStrategy implements PlayingStrategy {

    public boolean playNext(Game game, int diceMove, PlayerKey playerKey) {
        Player currentPlayer = game.getPlayers()
                .get(playerKey);

        int nextPostion = diceMove + currentPlayer.getPosition();

        GameConfig config = game.getConfig();

        if (!validMove(nextPostion, config)) return false;

        nextPostion = checkAndUpdatePosition(nextPostion, config);
        currentPlayer.setPosition(nextPostion);

        return true;
    }


    public boolean isPlayerWinner(Game game, Player player) {
        return Optional.ofNullable(player)
                .map(Player::getPosition)
                .filter(position -> game.getConfig().getEndPoint() == position)
                .isPresent();
    }

    private int checkAndUpdatePosition(int nextPostion, GameConfig config) {
        Map<Integer, Integer> snakes = config.getSnakes();
        Map<Integer, Integer> ladders = config.getLadders();

        while (snakes.containsKey(nextPostion) || ladders.containsKey(nextPostion)) {
            if (snakes.containsKey(nextPostion)) nextPostion = snakes.get(nextPostion);
            else if (ladders.containsKey(nextPostion)) nextPostion = ladders.get(nextPostion);
        }

        return nextPostion;
    }

    private boolean validMove(int nextPostion, GameConfig config) {
        return config.getEndPoint() >= nextPostion && config.getStartPoint() <= nextPostion;
    }

}
