package com.nirley.mock.printer;

import com.nirley.snakeladders.player.Player;

public interface GamePrinter {

    void printPlayerMoves(Player player, int lastPosition, int diceMove);

    void printPlayerWin(Player player);
}
