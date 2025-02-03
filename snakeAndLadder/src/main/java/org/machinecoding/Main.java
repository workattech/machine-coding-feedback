package org.machinecoding;

import org.machinecoding.models.Board;
import org.machinecoding.services.GameController;
import org.machinecoding.models.Dice;
import org.machinecoding.models.Player;
import org.machinecoding.models.teleports.Ladder;
import org.machinecoding.models.teleports.Snake;
import org.machinecoding.models.teleports.TeleporterEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int targetCell = 100;

        int numSnakes = scan.nextInt();
        List<TeleporterEntity> teleporterList = new ArrayList<>();
        for (int i = 0; i < numSnakes; i++)
            teleporterList.add(new Snake(scan.nextInt(), scan.nextInt()));

        int numLadder = scan.nextInt();
        for (int i = 0; i < numLadder; i++)
            teleporterList.add(new Ladder(scan.nextInt(), scan.nextInt()));

        int numPlayers = scan.nextInt();
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++)
            playerList.add(new Player(scan.next(), 0, targetCell));

        List<Dice> diceList = new ArrayList<>();
        diceList.add(new Dice());

        GameController gameController = new GameController(new Board(targetCell),
                teleporterList, playerList, diceList);
        gameController.start();
    }
}