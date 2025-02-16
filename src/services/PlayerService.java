package services;

import OutputWriter.OutputWriter;
import models.Player;

public class PlayerService {
    final OutputWriter outputWriter;
    final DiceService diceService;

    public PlayerService(OutputWriter outputWriter, DiceService diceService) {
        this.outputWriter = outputWriter;
        this.diceService = diceService;
    }

    public int rolldice(Player player) {
        return diceService.rollDice();
    }

    public void updatePosition(Player player, int newPosition) {
        player.setLastPosition(player.getCurrentPosition());
        player.setCurrentPosition(newPosition);
    }

}
