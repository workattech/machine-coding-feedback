package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class InputMappingService {
    private InputService inputService;
    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private ArrayList<String> players;

    public InputMappingService(InputService inputService){
        this.inputService = inputService;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        this.players = this.inputService.getPlayers();
    }

    void setSnakes(){
        this.inputService.getSnakes().forEach(snake ->
                {
                    if(! this.snakes.containsKey(snake.getHead())){
                        this.snakes.put(snake.getHead(), snake.getTail());
                    }
//                    else {
//                        try {
//                            throw new Exception("Two snakes cannot have same head");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
                );
    }

    void setLadders(){
        this.inputService.getLadders().forEach(ladder ->
                {
                    if(! this.ladders.containsKey(ladder.getStart())){
                        this.ladders.put(ladder.getStart(), ladder.getEnd());
                    }
//                    else {
//                        try {
//                            throw new Exception("Two ladders cannot have same start");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
        );
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
}
