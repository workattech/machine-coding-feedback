package com.enums;

public enum ChessPieceType {
	PAWN('P'),
	ROOK('R'),
	KNIGHT('N'),
	BISHOP('B'),
	QUEEN('Q'),
	KING('K'),
	NONE('-');
	

	private char value;
	
	private ChessPieceType(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
	
}
