package com.mtn.service;

import org.springframework.stereotype.Service;

import com.mtn.entity.Board;
import com.mtn.entity.Tile;

@Service
public class BoardService {

	private Board board;
	private int boardRows;
	private int boardColumns;
	
	public Board initializeBoard(int boardRows, int boardColumns) {
		board = new Board(boardRows, boardColumns);
		this.boardRows = boardRows;
		this.boardColumns = boardColumns;
		return board;
	}

	public void printBoard() {
		for (Tile[] tileArray : board.getBoard()) {
			for (Tile tile : tileArray) {
				System.out.print(tile.getValue()+" ");
			}
			System.out.println();
		}
	}

	public void makeLeftSideMove(Tile[][] board) {
		for(int i=0; i<boardRows; i++) {
			int k=0, j=0;
			while(j<boardColumns) {
				if(!board[i][j].getValue().equals("-")) {
					board[i][k].setValue(board[i][j].getValue());
					if(k!=j) board[i][j].setValue("-");
					k++;
					j++;
				}
				else {
					j++;
				}
			}
		}
	}

	public void mergeLeftSideMove(Tile[][] board) {
		for(int i=0; i<boardRows; i++) {
			for(int j=0; j<boardColumns-1; j++) {
				if(board[i][j].getValue().equals(board[i][j+1].getValue()) && !board[i][j].getValue().equals("-")) {
					board[i][j].setValue(Integer.toString(2 * Integer.parseInt(board[i][j].getValue())));
					board[i][j+1].setValue("-");
				}
			}
		}
	}

	public void makeRightSideMove(Tile[][] board) {
		for(int i=0; i<boardRows; i++) {
			int k=boardColumns-1, j=boardColumns-1;
			while(j>=0) {
				if(!board[i][j].getValue().equals("-")) {
					board[i][k].setValue(board[i][j].getValue());
					if(k!=j) board[i][j].setValue("-");
					k--;
					j--;
				}
				else {
					j--;
				}
			}
		}
	}

	public void mergeRightSideMove(Tile[][] board) {
		for(int i=0; i<boardRows; i++) {
			for(int j=boardColumns-1; j>0; j--) {
				if(board[i][j].getValue().equals(board[i][j-1].getValue()) && !board[i][j].getValue().equals("-")) {
					board[i][j].setValue(Integer.toString(2 * Integer.parseInt(board[i][j].getValue())));
					board[i][j-1].setValue("-");
				}
			}
		}
	}

	public void makeTopSideMove(Tile[][] board) {
		for(int i=0; i<boardColumns; i++) {
			int k=0, j=0;
			while(j<boardRows) {
				if(!board[j][i].getValue().equals("-")) {
					board[k][i].setValue(board[j][i].getValue());
					if(k!=j) board[j][i].setValue("-");
					k++;
					j++;
				}
				else {
					j++;
				}
			}
		}
	}

	public void mergeTopSideMove(Tile[][] board) {
		for(int i=0; i<boardColumns; i++) {
			for(int j=0; j<boardRows-1; j++) {
				if(board[j][i].getValue().equals(board[j+1][i].getValue()) && !board[j][i].getValue().equals("-")) {
					board[j][i].setValue(Integer.toString(2 * Integer.parseInt(board[j][i].getValue())));
					board[j+1][i].setValue("-");
				}
			}
		}
	}

	public void makeBottomSideMove(Tile[][] board) {
		for(int i=0; i<boardColumns; i++) {
			int k=boardRows-1, j=boardRows-1;
			while(j>=0) {
				if(!board[j][i].getValue().equals("-")) {
					board[k][i].setValue(board[j][i].getValue());
					if(k!=j) board[j][i].setValue("-");
					k--;
					j--;
				}
				else {
					j--;
				}
			}
		}
	}

	public void mergeBottomSideMove(Tile[][] board) {
		for(int i=0; i<boardColumns; i++) {
			for(int j=boardRows-1; j>0; j--) {
				if(board[j][i].getValue().equals(board[j-1][i].getValue()) && !board[j][i].getValue().equals("-")) {
					board[j][i].setValue(Integer.toString(2 * Integer.parseInt(board[j][i].getValue())));
					board[j-1][i].setValue("-");
				}
			}
		}
	}

}
