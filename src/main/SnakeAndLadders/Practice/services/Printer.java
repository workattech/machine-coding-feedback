package SnakeAndLadders.Practice.services;

import SnakeAndLadders.Practice.model.Player;

abstract class Printer {
    abstract void printNextMove(Player player, int diceNumber, int nextPosition);
    abstract void printWinMove(Player player);
}

class CMDPrinter extends Printer {

    @Override
    void printNextMove(Player player, int diceNumber, int nextPosition) {
        System.out.println(player.getName() + " rolled " + diceNumber + " and moved from " + player.getPosition() + " to " + nextPosition);
    }

    @Override
    void printWinMove(Player player) {
        System.out.println(player.getName()+" wins the game");
    }
}


