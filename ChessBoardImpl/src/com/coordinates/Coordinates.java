package com.coordinates;

import com.enums.ChessCellColor;

public class Coordinates {
	private int x;
	
	private int y;
	
	private ChessCellColor chessCellColor;
	

	public Coordinates(int x, int y, ChessCellColor chessCellColor) {
		this.x = x;
		this.y = y;
		this.chessCellColor = chessCellColor;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ChessCellColor getChessCellColor() {
		return chessCellColor;
	}
	
	
}
