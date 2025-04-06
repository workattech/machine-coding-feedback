package com.chessPiece;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceType;

public class NoChessPiece extends ChessPiece {

	public NoChessPiece() {
		super(ChessPieceType.NONE, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void instantiatePossibleDirections() {
		// TODO Auto-generated method stub
		
	}


}
