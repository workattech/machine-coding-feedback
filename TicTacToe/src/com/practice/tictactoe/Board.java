package com.practice.tictactoe;

public class Board {
	private int gridSize;
	private String[][] board;
	public Board(int gridSize) {
		this.gridSize = gridSize;
		this.board = new String[gridSize][gridSize];
	}
	public Board(int gridSize, String[][] board) {
		super();
		this.gridSize = gridSize;
		this.board = board;
	}
	public int getGridSize() {
		return gridSize;
	}
	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	public String[][] getBoard() {
		return board;
	}
	public void setBoard(String[][] board) {
		this.board = board;
	}
}
