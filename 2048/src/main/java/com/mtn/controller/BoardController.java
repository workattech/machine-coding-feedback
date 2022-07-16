package com.mtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mtn.entity.Board;
import com.mtn.entity.Tile;
import com.mtn.service.BoardService;
import com.mtn.service.TileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private TileService tileService;

	public Board initializeBoard(int defNumRows, int defNumColumns) {
		return boardService.initializeBoard(defNumRows, defNumColumns);
	}

	public void printBoard() {
		boardService.printBoard();
	}

	public void setRandomTileValue(Tile[][] board, String string) {
		tileService.setRandomTileValue(board, string);
	}

	public void makeLeftSideMove(Tile[][] board) {
		boardService.makeLeftSideMove(board);
		boardService.mergeLeftSideMove(board);
		boardService.makeLeftSideMove(board);
	}

	public void makeRightSideMove(Tile[][] board) {
		boardService.makeRightSideMove(board);
		boardService.mergeRightSideMove(board);
		boardService.makeRightSideMove(board);
	}

	public void makeTopSideMove(Tile[][] board) {
		boardService.makeTopSideMove(board);
		boardService.mergeTopSideMove(board);
		boardService.makeTopSideMove(board);
	}

	public void makeBottomSideMove(Tile[][] board) {
		boardService.makeBottomSideMove(board);
		boardService.mergeBottomSideMove(board);
		boardService.makeBottomSideMove(board);
	}

	public boolean isGameOver(Tile[][] board) {
		for (Tile[] tilesArray : board) {
			for (Tile tiles : tilesArray) {
				if(tiles.getValue().equals("-"))
					return false;
			}
		}
		return true;
	}

	public boolean isGameWon(Tile[][] board, int defWinningValue) {
		for (Tile[] tilesArray : board) {
			for (Tile tiles : tilesArray) {
				if(tiles.getValue().equals(""+defWinningValue))
					return true;
			}
		}
		return false;
	}
	
	
}
