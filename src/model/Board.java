package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    int size;
    Map<Integer, Integer> snakesMap;
    Map<Integer, Integer> laddersMap;

    public Board() {
        this.size = 100;
    }

    public Board(int size) {
        this.size = size;
    }

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        this.size = 100;
        snakesMap = new HashMap<>();
        addSnakesToBoard(snakes);
        laddersMap = new HashMap<>();
        addLaddersToBoard(ladders);
    }

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        snakesMap = new HashMap<>();
        addSnakesToBoard(snakes);
        laddersMap = new HashMap<>();
        addLaddersToBoard(ladders);
    }

    public void addSnakesToBoard(List<Snake> snakes) {
        for (Snake snake : snakes) {
            snakesMap.put(snake.start, snake.end);
        }
    }

    public void addLaddersToBoard(List<Ladder> ladders) {
        for (Ladder ladder : ladders) {
            laddersMap.put(ladder.start, ladder.end);
        }
    }

    public boolean cellHasSnakeOrLadder(int cell) {
        return cellHasSnake(cell) || cellHasLadder(cell);
    }

    public boolean cellHasSnake(int cell) {
        if (cell < 1 || cell > size) throw new IllegalArgumentException();
        return snakesMap.containsKey(cell);
    }

    public boolean cellHasLadder(int cell) {
        if (cell < 1 || cell > size) throw new IllegalArgumentException();
        return laddersMap.containsKey(cell);
    }

    public int getEndOfSnake(int cell) {
        if (!cellHasSnake(cell)) throw new IllegalArgumentException();
        return snakesMap.get(cell);
    }

    public int getEndOfLadder(int cell) {
        if (!cellHasLadder(cell)) throw new IllegalArgumentException();
        return laddersMap.get(cell);
    }

    public int getSize() {
        return size;
    }

}
