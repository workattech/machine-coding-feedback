package com.games.snakesandladders.props;

public class Cell {
  private Snake snake;
  private Ladder ladder;

  public boolean containsSnake() {
    return (this.snake != null);
  }

  public boolean containsLadder() {
    return (this.ladder != null);
  }

  public Snake getSnake() {
    return snake;
  }

  public void setSnake(Snake snake) {
    this.snake = snake;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public void setLadder(Ladder ladder) {
    this.ladder = ladder;
  }
}
