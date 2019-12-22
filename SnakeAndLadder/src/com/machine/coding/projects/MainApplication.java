package com.machine.coding.projects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.machine.coding.projects.dto.Ladders;
import com.machine.coding.projects.dto.Person;
import com.machine.coding.projects.dto.Position;
import com.machine.coding.projects.dto.Snakes;
import com.machine.coding.projects.service.GameService;
import com.machine.coding.projects.service.GameServiceFactory;

public class MainApplication {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        GameService gameService = GameServiceFactory.getGame("SnakeAndLadder");

        gameService.initialize(sc);

        gameService.playGame();

        String winner = gameService.getWinner();

        System.out.println("Winner: " + winner);
    }

}
