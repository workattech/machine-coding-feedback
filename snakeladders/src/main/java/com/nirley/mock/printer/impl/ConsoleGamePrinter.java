package com.nirley.mock.printer.impl;

import com.nirley.mock.player.Player;
import com.nirley.mock.printer.GamePrinter;

public class ConsoleGamePrinter implements GamePrinter {

    private String MOVE_PRINT_TEMPLATE = "%s rolled a %s and moved from %s to %s";
    private String WINNER_PRINT_TEMPLATE = "%s wins the com.nirley.mock.game";

    @Override
    public void printPlayerMoves(Player player, int lastPosition, int diceMove) {
        System.out.println(String.format(MOVE_PRINT_TEMPLATE, player.getName(), diceMove, lastPosition, player.getPosition()));
    }

    @Override
    public void printPlayerWin(Player player) {
        System.out.println(String.format(WINNER_PRINT_TEMPLATE, player.getName()));
    }
}
