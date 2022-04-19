package Models;

import java.util.*;

import Models.*;

public class Board {
    final private static int DEFAULT_BOARD_SIZE = 100;
    private int size;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;

    public Board(int size, ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board(ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        this.size = Board.DEFAULT_BOARD_SIZE;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return this.size;
    }

    public ArrayList<Snake> getSnakes() {
        return this.snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return this.ladders;
    }
}