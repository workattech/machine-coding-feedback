package com.chessPiece;

import java.util.stream.Stream;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class QueenChessPiece extends ChessPiece {

	public QueenChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.QUEEN, chessPieceColor);
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		return super.isValidMove(startPosition, endPosition, chessBoard);
	}

	@Override
	protected void instantiatePossibleDirections() {
		Stream.of(Direction.values()).forEach(s -> {
			this.possibleDirections.add(s);
		});
	}

}
