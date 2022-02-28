package com.mtn;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtn.controller.BoardController;
import com.mtn.entity.Board;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner{
	
	private static final int DEF_NUM_ROWS = 4;
	private static final int DEF_NUM_COLUMNS = 4;
	private static final int DEF_WINNING_VALUE = 2048;

	@Autowired
	private BoardController boardController;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		Board board = boardController.initializeBoard(DEF_NUM_ROWS, DEF_NUM_COLUMNS);
		boardController.setRandomTileValue(board.getBoard(), "2");
		boardController.setRandomTileValue(board.getBoard(), "2");
		boardController.printBoard();
		boolean isGameOver = false;
		boolean isGameWon = false;
		while(!isGameOver && !isGameWon) {
			int nextMove = sc.nextInt();
			switch (nextMove) {
			case 0:
				boardController.makeLeftSideMove(board.getBoard());
				break;
			case 1:
				boardController.makeRightSideMove(board.getBoard());
				break;
			case 2:
				boardController.makeTopSideMove(board.getBoard());
				break;
			case 3:
				boardController.makeBottomSideMove(board.getBoard());
				break;
			default:
				System.out.println("Invalid Move");
				break;
			}
			boardController.setRandomTileValue(board.getBoard(), "3");
			boardController.printBoard();
			isGameOver = boardController.isGameOver(board.getBoard());
			isGameWon = boardController.isGameWon(board.getBoard(), DEF_WINNING_VALUE);
		}
		if(isGameWon) {
			System.out.println("Congratulations!");
		}
		else if(isGameOver) {
			System.out.println("Game over");
		}
		sc.close();
	}

}
