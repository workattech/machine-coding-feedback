package com.pankaj.tictactoegame.service;

import com.pankaj.tictactoegame.models.Player;

public interface ITicTacToeService {
	boolean performMove(int row, int col, Player player);

	void displayGrid();

	void isWon(Player player, int i, int j);
}
