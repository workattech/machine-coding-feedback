package com.pankaj.tictactoegame;

import java.util.Scanner;

import com.pankaj.tictactoegame.models.Player;
import com.pankaj.tictactoegame.service.ITicTacToeService;
import com.pankaj.tictactoegame.service.impl.TicTacToeService;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		Scanner io = new Scanner(System.in);
		ITicTacToeService ticTacToeService = new TicTacToeService();
		Player player1 = null, player2 = null;
		boolean turn = true;
		ticTacToeService.displayGrid();
		System.out.println("Provide The Input Test Cases Below!!!");
		System.out.println();
		
		while (io.hasNextLine()) {
			String input = io.nextLine();
			System.out.println();
			String[] commands = input.trim().split(" ");
			String command = commands[0];

			if (command.equals("X")) {
				String name = commands[1];
				player1 = new Player(name, 'X');
			} else if (command.equals("O")) {
				String name = commands[1];
				player2 = new Player(name, 'O');
			} else if (Integer.parseInt(commands[0]) >= 1 && Integer.parseInt(commands[0]) <= 3
					&& Integer.parseInt(commands[1]) >= 1 && Integer.parseInt(commands[1]) <= 3) {
				String row = commands[0];
				String col = commands[1];

				if (turn) {
					if (ticTacToeService.performMove(Integer.parseInt(row), Integer.parseInt(col), player1)) {
						turn = false;
						ticTacToeService.displayGrid();
						System.out.println();
						isgameOver(player1, player2);
						ticTacToeService.isWon(player1, Integer.parseInt(row), Integer.parseInt(col));
					}
				} else {
					if (ticTacToeService.performMove(Integer.parseInt(row), Integer.parseInt(col), player2)) {
						turn = true;
						ticTacToeService.displayGrid();
						System.out.println();
						isgameOver(player1, player2);
						ticTacToeService.isWon(player2, Integer.parseInt(row), Integer.parseInt(col));
					}
				}
			} else if (command.equals("exit")) {
				System.exit(0);
			} else
				throw new IllegalStateException("Invalid Command");

		}

	}

	private static void isgameOver(Player player1, Player player2) {
		if (player1.getMovestaken() + player2.getMovestaken() == 9) {
			System.out.println("GAME OVER!!!");
			System.exit(0);
		}
	}

}
