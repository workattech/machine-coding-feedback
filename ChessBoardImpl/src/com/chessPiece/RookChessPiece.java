package com.chessPiece;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class RookChessPiece extends ChessPiece {

	public RookChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.ROOK, chessPieceColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		return super.isValidMove(startPosition, endPosition, chessBoard);
	}

	@Override
	protected void instantiatePossibleDirections() {
		this.possibleDirections.add(Direction.DOWN);
		this.possibleDirections.add(Direction.RIGHT);
		this.possibleDirections.add(Direction.UP);
		this.possibleDirections.add(Direction.LEFT);
	}

}
