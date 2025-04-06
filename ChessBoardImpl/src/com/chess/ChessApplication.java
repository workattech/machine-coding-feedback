package com.chess;

import com.chess.interfaces.IChessApplication;
import com.chessBoard.interfaces.IChessBoard;
import com.chessPiece.interfaces.IChessPiece;
import com.chessPiece.interfaces.IChessPieceFactory;
import com.coordinates.Coordinates;
import com.enums.ChessPieceType;

public class ChessApplication implements IChessApplication {

	private IChessBoard chessBoard;
	
	private IChessPieceFactory chessPieceFactory;
	
	@Override
	public boolean makeAMove(Coordinates startCoordinates, Coordinates endCoordinates) {
		if (!this.isValidMove(startCoordinates, endCoordinates)) {
			return false;
		}

		IChessPiece chessPiece = this.chessBoard.getChessPieceAtCoordinate(startCoordinates);
		
		this.chessBoard.setChessPieceAtCoordinate(startCoordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.NONE, null));
		this.chessBoard.setChessPieceAtCoordinate(endCoordinates, chessPiece);
		
		return true;
	}
	
	private boolean isValidMove(Coordinates startCoordinates, Coordinates endCoordinates) {
		return this.isValidMove(startCoordinates, endCoordinates);
	}

}
