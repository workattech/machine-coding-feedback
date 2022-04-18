package com.practice.game2048;

import java.util.*;

public class Board {
	private int gridSize;
	private int finalValue;
	private int baseValue;
	private int[][] board;
	public Board(int gridSize, int finalValue, int baseValue) {
		this.gridSize = gridSize;
		this.finalValue = finalValue;
		this.baseValue = baseValue;
		this.board = new int[gridSize][gridSize];
	}
	public int[][] getBoard() {
		return board;
	}
	public int getGridSize() {
		return gridSize;
	}
	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	public int getFinalValue() {
		return finalValue;
	}
	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}
	public int getBaseValue() {
		return baseValue; 
	}
	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}
}
