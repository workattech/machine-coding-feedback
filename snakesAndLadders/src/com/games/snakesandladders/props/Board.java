package com.games.snakesandladders.props;

public class Board {
  private final int BOARD_SIZE = 100;
  private final Cell[] cells;

  public Board(Snake[] snakes, Ladder[] ladders) {
    cells = new Cell[BOARD_SIZE + 1];
    for (int i = 0; i < cells.length; ++i) {
      cells[i] = new Cell();
    }
    for (Snake snake : snakes) {
      cells[snake.getHead()].setSnake(snake);
    }
    for (Ladder ladder : ladders) {
      cells[ladder.getStart()].setLadder(ladder);
    }
  }

  public int getFinalPosition(int initialPosition, int diceNumber) {
    int finalPosition = initialPosition + diceNumber;
    finalPosition = Math.min(finalPosition, BOARD_SIZE);
    while (cells[finalPosition].containsSnake() || cells[finalPosition].containsLadder()) {
      if (cells[finalPosition].containsSnake()) {
        finalPosition = cells[finalPosition].getSnake().getTail();
      } else {
        finalPosition = cells[finalPosition].getLadder().getEnd();
      }
    }
    return finalPosition;
  }

  public boolean isFinalCell(int position) {
    return (position == BOARD_SIZE);
  }
}
