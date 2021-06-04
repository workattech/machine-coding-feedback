package main.java.models;

import java.util.List;

public class GameBoard {
  private List<Ladder> ladders;
  private List<Snake> snakes;
  private List<Player> players;
  private int size;

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<Ladder> getLadders() {
    return ladders;
  }

  public void setLadders(List<Ladder> ladders) {
    this.ladders = ladders;
  }

  public List<Snake> getSnakes() {
    return snakes;
  }

  public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
