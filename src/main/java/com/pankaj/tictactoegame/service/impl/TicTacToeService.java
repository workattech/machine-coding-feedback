package com.pankaj.tictactoegame.service.impl;

import com.pankaj.tictactoegame.models.Grid;
import com.pankaj.tictactoegame.models.Player;
import com.pankaj.tictactoegame.service.ITicTacToeService;

public class TicTacToeService implements ITicTacToeService{
	Grid grid = new Grid();

	@Override
	public boolean performMove(int row, int col, Player player) {
		return (this.grid.playerMove(row, col, player));
	}

	@Override
	public void displayGrid() {
		grid.displayGrid();
		
	}

	@Override
	public void isWon(Player player, int row, int col) {
		grid.isWon(player, row, col);
	}
}
