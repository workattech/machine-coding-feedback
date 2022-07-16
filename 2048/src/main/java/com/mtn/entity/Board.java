package com.mtn.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private Tile[][] board;
	
	public Board(int boardRows, int boardColumns) {
		this.board = new Tile[boardRows][boardColumns];
		initialize(boardRows, boardColumns);
	}

	private void initialize(int boardRows, int boardColumns) {
		for(int i=0; i<boardRows; i++) {
			for(int j=0; j<boardColumns; j++) {
				board[i][j] = new Tile("-");
			}
		}
	}
}
