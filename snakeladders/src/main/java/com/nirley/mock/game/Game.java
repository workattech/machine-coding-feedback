package com.nirley.mock.game;

import com.nirley.mock.game.config.GameConfig;
import com.nirley.mock.player.Player;
import com.nirley.mock.player.PlayerKey;
import com.nirley.mock.printer.GamePrinter;
import com.nirley.mock.printer.impl.ConsoleGamePrinter;
import com.nirley.mock.strategy.PlayingStrategy;
import com.nirley.mock.strategy.impl.DefaultPlayingStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {

    private GameConfig config;
    private Map<PlayerKey, Player> players;
    private PlayingStrategy playingStrategy;
    private GamePrinter printer;

    Game(GameConfig config, PlayingStrategy playingStrategy, List<Player> playerList, GamePrinter printer) {
        this.config = config;
        this.playingStrategy = playingStrategy;
        this.players = playerList.stream()
                .collect(Collectors.toMap(Player::getPlayerKey, Function.identity()));
        this.printer = printer;
    }

    public Game(GameConfig config, List<Player> playerList) {
        this(config, new DefaultPlayingStrategy(), playerList, new ConsoleGamePrinter());
    }

    public Map<PlayerKey, Player> getPlayers() {
        return players;
    }

    public GameConfig getConfig() {
        return config;
    }

    public boolean isComplete() {
        return getPlayers()
                .values()
                .stream()
                .filter(player -> player.getPosition() == getConfig().getEndPoint())
                .findFirst()
                .isPresent();
    }

    public boolean playNext(PlayerKey playerKey) {
        Player currentPlayer = players.get(playerKey);

        if (currentPlayer == null || isPlayerWinner(currentPlayer)) return false;

        int lastValidPosition = currentPlayer.getPosition();

        int diceMove = getConfig().getDices()
                .stream()
                .map(dice -> dice.rollDice())
                .reduce(Integer::sum)
                .orElse(0);

        boolean validMove = playingStrategy.playNext(this, diceMove, playerKey);
        if (validMove) printer.printPlayerMoves(currentPlayer, lastValidPosition, diceMove);

        if (isPlayerWinner(currentPlayer)) printer.printPlayerWin(currentPlayer);

        return validMove;
    }

    public boolean isPlayerWinner(Player player) {
        return playingStrategy.isPlayerWinner(this, player);
    }
}
