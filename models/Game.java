package com.kbh.snl.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

  private Integer totalCells;
  private List<Player> playersLeft;   /*List of players left to complete the game*/
  private Integer currentPlayer;
  private List<Snake> snakes;
  private List<Ladder> ladders;

  /** storing specific ladder/snake in the board
   *  Key:position on board
   *  vale:snake/ladder. Default value is null
   */
  private Map<Integer, IntermediateObject> board;

  /*Storing list of multiple winners in winning position respectively.*/
  private List<Player> sortedWinners;

  public Game(final List<Player> playersLeft, final List<Snake> snakes, final List<Ladder> ladders, final Integer totalCells) {
    this.playersLeft = playersLeft;
    this.snakes = snakes;
    this.ladders = ladders;
    this.board = initBoard(snakes, ladders);
    this.totalCells = totalCells;
    sortedWinners = new ArrayList<>();
  }
  /**
   * Initialize {@link Game#board} object with snakes and ladders
   *
   * @param snakes  list of all snakes
   * @param ladders list of all ladders
   * @return {@link Game#board}
   */

  private Map<Integer, IntermediateObject> initBoard(final List<Snake> snakes, final List<Ladder> ladders) {
    Map<Integer, IntermediateObject> newBoard = new HashMap<>();
    snakes.stream().forEach(snake -> { newBoard.put(snake.getStartPosition(), snake); });
    ladders.stream().forEach(ladder -> { newBoard.put(ladder.getStartPosition(), ladder); });

    return newBoard;
  }

  public List<Player> getPlayersLeft() {
    return playersLeft;
  }

  public Map<Integer, IntermediateObject> getBoard() {
    return board;
  }

  public List<Player> getSortedWinners() {
    return sortedWinners;
  }

  public Integer getTotalCells() {
    return totalCells;
  }
}
