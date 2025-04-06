package com.chessPiece;

import java.util.stream.Stream;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class KingChessPiece extends ChessPiece {

	public KingChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.KING, chessPieceColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		if (!super.isValidMove(startPosition, endPosition, chessBoard)) {
			return false;
		}
		
		if (chessBoard.getBlockedPositionsForKing(this.getChessPieceColor()).contains(endPosition)) {
			return false;
		}
		
		int diffX = startPosition.getX() - endPosition.getX();
		
		int diffY = startPosition.getY() - endPosition.getY();
		
		if (diffX < -1 || diffX > 1) {
			return false;
		}
		
		if (diffY < -1 || diffY > 1) {
			return false;
		}
		
		return true;
	}

	@Override
	protected void instantiatePossibleDirections() {
		Stream.of(Direction.values()).forEach(s -> {
			this.possibleDirections.add(s);
		});
	}



}
