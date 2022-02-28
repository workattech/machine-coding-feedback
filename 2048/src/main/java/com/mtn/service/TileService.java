package com.mtn.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.mtn.entity.Tile;

@Service
public class TileService {

	public void setRandomTileValue(Tile[][] board, String string) {
		boolean isSetRandomTileValueToTwo = false;
		while(!isSetRandomTileValueToTwo) {
			int max = 4;
			Random rand = new Random();
			int randomRow = rand.nextInt(max);
			int randomColumn = rand.nextInt(max);
			if(board[randomRow][randomColumn].getValue().equals("-")) {
				if(string.equals("2")) {
					board[randomRow][randomColumn].setValue("2");
				}
				else {
					int randomPowerOfTwo = 1 + rand.nextInt(10);
					board[randomRow][randomColumn].setValue(Integer.toString((int) Math.pow(2, randomPowerOfTwo)));
				}
				isSetRandomTileValueToTwo = true;
			}
		}
	}

}
