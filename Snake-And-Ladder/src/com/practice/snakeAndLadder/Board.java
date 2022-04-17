package com.practice.snakeAndLadder;
import java.util.*;

public class Board {
	private int boardSize;
	private HashMap<Integer, SnakeLadder> board = new HashMap<>();
	public Board(int boardSize) {
		this.boardSize = boardSize;
	}
	public int getBoardSize() {
		return boardSize;
	}
	public void intializeBoard() {
		for(int cell=0; cell<=this.boardSize; cell++) {
			board.put(cell, new SnakeLadder(){});
		}
	}
	public HashMap<Integer, SnakeLadder> getBoard() {
		return board;
	}
}
