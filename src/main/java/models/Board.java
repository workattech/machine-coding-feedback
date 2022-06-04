package models;

import java.util.List;

public class Board {
    private int size;
    private List<Ladder> ladders;
    private List<Snake> snakes;

    public Board( int size, List<Ladder> ladders, List<Snake> snakes) {
        if(size<=0) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }

        for (Snake snake : snakes) {
            if (snake == null) {
                throw new IllegalArgumentException("snake must not be null.");
            }

            if (snake.getHead() > size || snake.getTail() > size) {
                throw new IllegalArgumentException("head or tail position must be within board.");
            }
        }

        for (Ladder ladder : ladders) {
            if(ladder == null) {
                throw new IllegalArgumentException("ladder must not be null");
            }
            if (ladder.getStart() > size || ladder.getEnd() > size) {
                throw new IllegalArgumentException("start or end position must be within board.");
            }
        }
        this.size = size;
        this.ladders = ladders;
        this.snakes = snakes;
    }

    public boolean isValidCell(int cellNumber) {
        return cellNumber<=size;
    }

    public Snake getSnake(int position) {
        Snake lsnake = null;
        for (Snake snake :
                snakes) {
            if(snake.getHead()== position) {
                lsnake = snake;
            }
        }
        return lsnake;
    }

    public Ladder getLadder(int position) {
        Ladder gladder = null;
        for (Ladder ladder :
                ladders) {
            if(ladder.getStart()== position) {
                gladder = ladder;
            }
        }
        return gladder;
    }

    public int getSize() {
        return size;
    }
}
