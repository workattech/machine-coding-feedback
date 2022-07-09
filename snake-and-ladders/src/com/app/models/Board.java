package com.app.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Board {
    private int Size;
    private Map<Integer, Cell> cells;

    int getSize() {
        return Size;
    }

    Board(int size, List<Jump> snakes, List<Jump> ladders) {
        Size = size;
        cells = new HashMap<>();
        for (Jump snake:snakes)
        {
            cells.put(snake.getStartPosition(), new Cell(snake.getStartPosition(), snake.getEndPosition()));
        }
        for (Jump ladder:ladders)
        {
            cells.put(ladder.getStartPosition(), new Cell(ladder.getStartPosition(), ladder.getEndPosition()));
        }

    }

    int updatePlayerPosition(int currentPosition, int movements)
    {
        int newPosition = currentPosition + movements;
        newPosition = this.checkAndGetEndPosition(newPosition);
        return newPosition > this.Size ? currentPosition:newPosition;
    }

    private int checkAndGetEndPosition(int position)
    {
        Cell cell = this.cells.get(position);
        if (Objects.nonNull(cell))
        {
            return checkAndGetEndPosition(cell.getEndPosition());
        }
        return position;
    }

}
