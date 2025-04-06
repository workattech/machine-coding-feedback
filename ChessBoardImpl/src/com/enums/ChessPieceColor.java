package com.enums;

public enum ChessPieceColor {
	
	BLACK('B'),
	WHITE('W'),
	NONE('-');
	
	private char value;
	
	private ChessPieceColor(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
	
	
	
}
