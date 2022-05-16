package com.practice.game2048;

import java.util.Scanner;

public class BoardManager {
	BoardService boardService;
	public BoardManager(int gridSize, int finalValue, int baseValue) {
		boardService = new BoardService(gridSize, finalValue, baseValue);
	}
	void play() {
		Scanner sc = new Scanner(System.in); 
		boardService.intialize();
		do {
			boardService.printBoard();
			int direction = sc.nextInt();
			switch(direction) {
				case 0: {
					boardService.moveLeft();
					if(boardService.checkIfWon() == true) {
						System.out.println("Congratulations");
						return ;
					}
					break;
				}
				case 1: {
					boardService.moveRight();
					if(boardService.checkIfWon() == true) {
						System.out.println("Congratulations");
						return ;
					}
					break;
				}
				case 2: {
					boardService.moveUp();
					if(boardService.checkIfWon() == true) {
						System.out.println("Congratulations");
						return ;
					}
					break;
				}
				case 3: {
					boardService.moveDown();
					if(boardService.checkIfWon() == true) {
						System.out.println("Congratulations");
						return ;
					}
					break;
				}
				case 4: {
					System.out.println("Exited : Game Over");
					return ;
				}
				default: {
					System.out.println("Invalid Direction");
				}
					
			}
		} while(boardService.setNextFreeSlot() != false);
		
		if(boardService.checkIfWon()) {
			System.out.println("Congratulations");
		}
		else {
			System.out.println("Game Over");
		}
	}
}
