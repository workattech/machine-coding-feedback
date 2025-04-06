package com.chessPiece;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class KnightChessPiece extends ChessPiece {

	public KnightChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.KNIGHT, chessPieceColor);
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		if (!super.isValidMove(startPosition, endPosition, chessBoard)) {
			return false;
		}
		
		int diffX = startPosition.getX() - endPosition.getY();
		
		int diffY = startPosition.getY() - endPosition.getY();
		
		if (this.getAbsValue(diffY) > 2 || this.getAbsValue(diffX) > 2 ||  this.getAbsValue(diffY) + this.getAbsValue(diffX) != 3) {
			return false;
		}
		
		return true;
	}

	@Override
	protected void instantiatePossibleDirections() {
		this.possibleDirections.add(Direction.RANDOM);
	}

}
