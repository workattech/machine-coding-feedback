package com.pankaj.tictactoegame.models;

import java.util.List;

public class Grid {
	public Grid() {
		cells = generateCells();
	}

	private Cell[][] generateCells() {
		Cell[][] cells = new Cell[4][4];
		for(int i=1; i<=3 ; i++) {
			for(int j=1; j<=3; j++) {
				Cell cell = new Cell();
				cells[i][j]=cell;
			}
		}	
		return cells;
	}

	private Cell[][] cells;

	public boolean playerMove(int row, int col, Player player) {
		Cell cell = cells[row][col];
		if (cell.getIsOccupied()) {
			System.out.println("Invalid Move!!!");
			return false;
		} else {
			cell.performMove(player);
			return true;
		}
	}

	public void displayGrid() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.print(cells[i][j].getType());
			}
			System.out.println();
		}
	}

	public void isWon(Player player, int row, int col) {
		char type = player.getType();

		int cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (type == cells[row][i].getType())
				cnt++;
		}
		if (cnt == 3) 
			displayWonMessage(player);
			
		cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (type == cells[i][col].getType())
				cnt++;
		}
		if (cnt == 3) 
			displayWonMessage(player);

		cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (type == cells[i][i].getType())
				cnt++;
		}
		if (cnt == 3) 
			displayWonMessage(player);

		cnt = 0;
		for (int i = 3; i >= 1; i--) {
			if (type == cells[4 - i][i].getType())
				cnt++;
		}
		if (cnt == 3) 
			displayWonMessage(player);
	}

	private void displayWonMessage(Player player) {
		System.out.println("Congralutions!!! Player " + player.getName() + " has won the game!!!");
		System.exit(0);
	}
}
