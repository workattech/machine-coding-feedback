package com.practice.tictactoe;

public class BoardService {
	private static final String HYPHEN = "-";
	Board boardInstance;
	String[][] board;
	public BoardService(int gridSize) {
		boardInstance = new Board(gridSize);
		board = boardInstance.getBoard();
	}
	
	void intialize() {
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				board[row][col] = HYPHEN;
			}
		}
	}
	
	boolean isValid(int row, int col) {
		return (row >= 0 && row < boardInstance.getGridSize() && col >=0 && col < boardInstance.getGridSize() && this.board[row][col].equals(HYPHEN));
	}
	
	boolean allCellsOccupied() {
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				if(this.board[row][col].equals(HYPHEN)) {
					return true;
				}
			}
		}
		return false;
	}
	boolean checkIfWon(User u, int x, int y) {
		//check left to right diagonal
		boolean leftToRight = true, rightToLeft = true, horizontal = true, vertical = true;
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			if(!(this.board[row][row].equals(u.getPiece()))) {
				leftToRight = false;
			}
		}
		//check right to left diagonal
		for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
			if(!(this.board[row][boardInstance.getGridSize()-1-row].equals(u.getPiece()))) {
				rightToLeft = false;
			}
		}
		//check vertical
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			if(!(this.board[row][y].equals(u.getPiece()))) {
				vertical = false;
			}
		}
		//check horizontal
		for(int col=0; col<boardInstance.getGridSize(); col++) {
			if(!(this.board[x][col].equals(u.getPiece()))) {
				horizontal = false;
			}
		}
		return leftToRight || rightToLeft || horizontal || vertical;
	}
	void makeMove(User u, int x, int y) {
		this.board[x][y] = u.getPiece();
	}
	void printBoard() {
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				System.out.print(this.board[row][col] + " ");
			}
			System.out.println();
			
		}
	}
}
