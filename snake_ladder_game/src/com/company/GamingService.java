package com.company;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GamingService {
    private InputMappingService inputMappingService;
    private HashMap<String, Integer> currentPositions;

    public GamingService(InputMappingService inputMappingService){
        this.inputMappingService = inputMappingService;
        currentPositions = new HashMap<>();
        this.inputMappingService.getPlayers().forEach(player ->
                {
                    if(! this.currentPositions.containsKey(player)){
                        this.currentPositions.put(player, new Integer("0"));
                    }
                }
                );
    }

    public void playGame(){
        int noOfPlayers = this.inputMappingService.getPlayers().size();
        ArrayList<String> players = this.inputMappingService.getPlayers();
        boolean gameComplete = false;
        Random random = new SecureRandom();
        while (!gameComplete){
            int countPlayers = 0;
            while (countPlayers < noOfPlayers){
                int diceCount = random.nextInt(6) + 1;
                System.out.print(players.get(countPlayers) + " rolled a " + diceCount +
                        " and moved from " + this.currentPositions.get(players.get(countPlayers)) + " to " );
                int finalPosition = this.currentPositions.get(players.get(countPlayers)) + diceCount;

                if(finalPosition > 100){
                    finalPosition = finalPosition - diceCount;
                }

                while(isSnakeAtPosition(finalPosition) || isLadderAtPosition(finalPosition)){
                    if(isSnakeAtPosition(finalPosition)){
//                        System.out.print("Snake eats " + players.get(countPlayers) + " from " + finalPosition + " to ");
                        finalPosition = this.inputMappingService.getSnakes().get(finalPosition);
//                        System.out.print(finalPosition + "\n");
                    }
                    else if(isLadderAtPosition(finalPosition)){
//                        System.out.print("Ladder climbs " + players.get(countPlayers) + " from " + finalPosition + " to ");
                        finalPosition = this.inputMappingService.getLadders().get(finalPosition);
//                        System.out.print(finalPosition + "\n");
                    }
                }

                System.out.print(finalPosition + "\n");
                this.currentPositions.replace(players.get(countPlayers), finalPosition);

                if(finalPosition == 100){
                    System.out.println(players.get(countPlayers) + " wins the game.");
                    gameComplete = true;
                    break;
                }

                countPlayers++;
            }
        }
    }

    private boolean isLadderAtPosition(int finalPosition) {
        return this.inputMappingService.getLadders().containsKey(finalPosition);
    }

    private boolean isSnakeAtPosition(int finalPosition) {
        return this.inputMappingService.getSnakes().containsKey(finalPosition);
    }

}
