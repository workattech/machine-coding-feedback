package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputService {
    private static InputService inputService;
    private ArrayList<String> players;
    private ArrayList<String> moves;

    private InputService(){}

    public static synchronized InputService getInstance() {
        if (inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void getInputs(){
        players = new ArrayList<>();
        moves = new ArrayList<>();
        String path = "src/com/company/input.txt";
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            players.add(reader.readLine().split(" ")[1]);
            players.add(reader.readLine().split(" ")[1]);
            while ((line = reader.readLine()) != null){
                moves.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}