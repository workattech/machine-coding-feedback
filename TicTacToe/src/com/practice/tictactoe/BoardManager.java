package com.practice.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager {
	BoardService boardService;
	public BoardManager(int gridSize) {
		boardService = new BoardService(gridSize);
	}
	void play() {
		int totalPlayers = 2;
		User u1 = new User("Gaurav", "X", false);
		User u2 = new User("Sagar", "O", false);
		ArrayList<User> users = new ArrayList();
		users.add(u1);
		users.add(u2);
		boardService.intialize();
		Scanner sc = new Scanner(System.in);
		int turn = 0;
		do {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			if(boardService.isValid(x, y)) {
				while(users.get(turn).getDidIwin() == true) {
					turn = (turn + 1) % totalPlayers;
				}
				User currUser = users.get(turn);
				boardService.makeMove(currUser, x, y);
				boardService.printBoard();
				if(boardService.checkIfWon(currUser, x, y) == true) {
					users.get(turn).setDidIwin(true);
					totalPlayers--;
					System.out.println(currUser.getName() + " won the game");
				}
				turn = (turn + 1) % totalPlayers;
			}
			else {
				System.out.println("Invalid Move");
			}
		} while(totalPlayers > 1 && boardService.allCellsOccupied());
		
		if(totalPlayers > 1) {
			System.out.println("Game Over");
		}
	}
}
