package SnakeAndLadders.Practice.Services;

import SnakeAndLadders.Practice.Model.Players;

abstract class Printer {
    abstract void printNextMove(Players player,int diceNumber,int nextPosition);
    abstract void printWinMove(Players player);
}

class CMDPrinter extends Printer {

    @Override
    void printNextMove(Players player,int diceNumber, int nextPosition) {
        System.out.println(player.getName() + " rolled " + diceNumber + " and moved from " + player.getPosition() + " to " + nextPosition);
    }

    @Override
    void printWinMove(Players player) {
        System.out.println(player.getName()+" wins the game");
    }
}


