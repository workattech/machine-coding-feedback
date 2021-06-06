package com.main.snakeandladder;

import com.main.snakeandladder.models.Ladder;
import com.main.snakeandladder.models.Player;
import com.main.snakeandladder.models.Snake;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {
  public final int BOARD_SIZE = 100;
  List<Snake> snakes = new ArrayList<>();
  List<Ladder> ladders = new ArrayList<>();
  Map<Player, Integer> playerPiece = new HashMap<>();

  public int getBoardSize(){
    return  this.BOARD_SIZE;
  }
  public List<Snake> getSnakes() {
    return snakes;
  }

  public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
  }

  public List<Ladder> getLadders() {
    return ladders;
  }

  public void setLadders(List<Ladder> ladders) {
    this.ladders = ladders;
  }

  public Map<Player, Integer> getPlayerPiece() {
    return playerPiece;
  }

  public void setPlayerPiece(
      Map<Player, Integer> playerPiece) {
    this.playerPiece = playerPiece;
  }
}
