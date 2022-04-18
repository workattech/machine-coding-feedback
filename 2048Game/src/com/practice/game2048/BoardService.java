package com.practice.game2048;

import java.util.Arrays;
import java.util.Random;

public class BoardService {
	Board boardInstance;
	private int[][] board;
	public BoardService(int gridSize, int finalValue, int baseValue) {
		boardInstance = new Board(gridSize, finalValue, baseValue);
		board = boardInstance.getBoard();
	}
	
	void intialize() {
		for(int i=0; i<boardInstance.getGridSize(); i++) {
			Arrays.fill(board[i], 0);
		}
		int row1 = generateRandomNumber(0, boardInstance.getGridSize()/2-1);
		int col1 = generateRandomNumber(0, boardInstance.getGridSize()/2-1);
		int row2 = generateRandomNumber(boardInstance.getGridSize()/2, boardInstance.getGridSize()-1);
		int col2 = generateRandomNumber(boardInstance.getGridSize()/2, boardInstance.getGridSize()-1);
		board[row1][col1] = 2;
		board[row2][col2] = 2;
	}
	
	void reset() {
		for(int i=0; i<boardInstance.getGridSize(); i++) {
			Arrays.fill(this.board[i], 0);
		}
	}
	
	int generateRandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	
	void printBoard() {
		for(int i=0; i<boardInstance.getGridSize(); i++) {
			for(int j=0; j<boardInstance.getGridSize(); j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
	}
	int getValue() {
		int maxPower = (int) (Math.log(boardInstance.getFinalValue()) / Math.log(boardInstance.getBaseValue()));
		return (int) Math.pow(boardInstance.getBaseValue(), generateRandomNumber(boardInstance.getBaseValue(), maxPower));
	}
	boolean setNextFreeSlot() {
		for(int i=0; i<boardInstance.getGridSize(); i++) {
			for(int j=0; j<boardInstance.getGridSize(); j++) {
				if(this.board[i][j] == 0) {
					 this.board[i][j] = getValue();
					 return true;
				}
			}
		}
		return false;
	}
	boolean checkIfWon() {
		for(int i=0; i<boardInstance.getGridSize(); i++) {
			for(int j=0; j<boardInstance.getGridSize(); j++) {
				if(this.board[i][j] == boardInstance.getFinalValue()) {
					 return true;
				}
			}
		}
		return false;
	}
	void moveLeft() {
		int[][] helperBoard = new int[boardInstance.getGridSize()][boardInstance.getGridSize()];
		
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			int colB = 0;
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				if(this.board[row][col] != 0) {
					helperBoard[row][colB++] = this.board[row][col]; 
				}
			}
		}
		
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				if(col != boardInstance.getGridSize()-1 && helperBoard[row][col] != 0 && helperBoard[row][col] == helperBoard[row][col+1]) {
					int merge = helperBoard[row][col] + helperBoard[row][col+1];
					helperBoard[row][col] = merge;
					helperBoard[row][col+1] = 0;
				}
			}
		}
		
		this.reset();
		
		for(int row=0; row<boardInstance.getGridSize(); row++) {
			int colB = 0;
			for(int col=0; col<boardInstance.getGridSize(); col++) {
				if(helperBoard[row][col] != 0) {
					this.board[row][colB++] = helperBoard[row][col]; 
				}
			}
		}
	}
	
	void moveRight() {
		int[][] helperBoard = new int[boardInstance.getGridSize()][boardInstance.getGridSize()];
		
		for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
			int colB = boardInstance.getGridSize()-1;
			for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
				if(this.board[row][col] != 0) {
					helperBoard[row][colB--] = this.board[row][col]; 
				}
			}
		}
		
		for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
			for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
				if(col != 0 && helperBoard[row][col] != 0 && helperBoard[row][col] == helperBoard[row][col-1]) {
					int merge = helperBoard[row][col] + helperBoard[row][col-1];
					helperBoard[row][col] = merge;
					helperBoard[row][col-1] = 0;
				}
			}
		}
		
		this.reset();
		
		for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
			int colB = boardInstance.getGridSize()-1;
			for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
				if(helperBoard[row][col] != 0) {
					this.board[row][colB--] = helperBoard[row][col]; 
				}
			}
		}
	}
	
	void moveUp() {
		int[][] helperBoard = new int[boardInstance.getGridSize()][boardInstance.getGridSize()];
		
		for(int col=0; col<boardInstance.getGridSize(); col++) {
			int rowB = 0;
			for(int row=0; row<boardInstance.getGridSize(); row++) {
				if(this.board[row][col] != 0) {
					helperBoard[rowB++][col] = this.board[row][col];
				}
			}
		}
		
		for(int col=0; col<boardInstance.getGridSize(); col++) {
			for(int row=0; row<boardInstance.getGridSize(); row++) {
				if(row != boardInstance.getGridSize()-1 && helperBoard[row][col] != 0 && helperBoard[row][col] == helperBoard[row+1][col]) {
					int merge = helperBoard[row][col] + helperBoard[row+1][col];
					helperBoard[row][col] = merge;
					helperBoard[row+1][col] = 0;
				}
			}
		}
		
		this.reset();
		
		for(int col=0; col<boardInstance.getGridSize(); col++) {
			int rowB = 0;
			for(int row=0; row<boardInstance.getGridSize(); row++) {
				if(helperBoard[row][col] != 0) {
					this.board[rowB++][col] = helperBoard[row][col];
				}
			}
		}
	}
	
	void moveDown() {
		int[][] helperBoard = new int[boardInstance.getGridSize()][boardInstance.getGridSize()];
		
		for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
			int rowB = boardInstance.getGridSize()-1;
			for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
				if(this.board[row][col] != 0) {
					helperBoard[rowB--][col] = this.board[row][col];
				}
			}
		}
		
		for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
			for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
				if(row != 0 && helperBoard[row][col] != 0 && helperBoard[row][col] == helperBoard[row-1][col]) {
					int merge = helperBoard[row][col] + helperBoard[row-1][col];
					helperBoard[row][col] = merge;
					helperBoard[row-1][col] = 0;
				}
			}
		}
		
		this.reset();
		
		for(int col=boardInstance.getGridSize()-1; col>=0; col--) {
			int rowB = boardInstance.getGridSize()-1;
			for(int row=boardInstance.getGridSize()-1; row>=0; row--) {
				if(helperBoard[row][col] != 0) {
					this.board[rowB--][col] = helperBoard[row][col];
				}
			}
		}
	}
	
	int[][] getHelperBoard() {
		int[][] helperBoard = new int[boardInstance.getGridSize()][boardInstance.getGridSize()];
		for (int i = 0; i < boardInstance.getGridSize(); i++) {
	        helperBoard[i] = Arrays.copyOf(this.board[i], this.board[i].length);
	    }
		return helperBoard;
	}
}
