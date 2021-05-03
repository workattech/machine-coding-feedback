package com.company;

import java.util.ArrayList;

public class InputService {
    private static InputService inputService;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private ArrayList<String> players;

    private InputService(){}

    public static synchronized InputService getInstance(){
        if (inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    public void initializeArrays(){
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public ArrayList<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(ArrayList<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void addLadder(Ladder ladder){
        this.ladders.add(ladder);
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public void addSnake(Snake snake){
        this.snakes.add(snake);
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public void addPlayer(String player){
        this.players.add(player);
    }
}
