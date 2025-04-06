package com.chessPiece;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class BishopChessPiece extends ChessPiece {
	 
	
	public BishopChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.BISHOP, chessPieceColor);
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		return super.isValidMove(startPosition, endPosition, chessBoard);
	}

	@Override
	protected void instantiatePossibleDirections() {
		this.possibleDirections.add(Direction.LEFT_DOWN);
		this.possibleDirections.add(Direction.LEFT_UP);
		this.possibleDirections.add(Direction.RIGHT_DOWN);
		this.possibleDirections.add(Direction.RIGHT_UP);
	}

	
}
