package OutputWriter;

import models.Player;

public class OutputWriter {
    public void onTurnCompletion(Player player, int diceValue) {
        System.out.println(player.getName() + " rolled a " + diceValue + " moved from " + player.getLastPosition() + " from " + player.getCurrentPosition());
    }

    public  void onWin(Player player) {
        System.out.println(player.getName() + " won the game");
    }
}
