package service;

import models.Board;
import models.Ladders;
import models.Player;
import models.Snakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {
    public Board readInputs() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSnakes = Integer.parseInt(bufferedReader.readLine());
        Snakes snakes = new Snakes();

        for (int i=0; i<numberOfSnakes; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            snakes.addSnakes(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int numberOfLadders = Integer.parseInt(bufferedReader.readLine());
        Ladders ladders = new Ladders();

        for (int i=0; i<numberOfLadders; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            ladders.addLadders(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int numberOfPlayers = Integer.parseInt(bufferedReader.readLine());
        Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<numberOfPlayers; i++) {
            players[i] = new Player(bufferedReader.readLine());
        }

        int numberOfDice = 1;
        int numberOfCells = 100;
        return new Board(snakes, ladders, players, numberOfDice*6, numberOfCells);
    }
}
