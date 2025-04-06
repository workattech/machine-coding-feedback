package com.chessBoard;

import com.chessBoard.interfaces.IChessBoard;
import com.chessBoard.interfaces.IChessBoardInitialPositionInitiator;
import com.chessPiece.interfaces.IChessPieceFactory;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;

public class DefaultChessBoardInitialPositionInitiator implements IChessBoardInitialPositionInitiator {
	
	private IChessPieceFactory chessPieceFactory;
	
	

	public DefaultChessBoardInitialPositionInitiator(IChessPieceFactory chessPieceFactory) {
		this.chessPieceFactory = chessPieceFactory;
	}



	@Override
	public boolean setChessPieceAtCoordinate(Coordinates coordinates, IChessBoard chessBoard) {
		
		if (coordinates.getX() > 1 && coordinates.getY() < chessBoard.getMaxX() - 2) {
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.NONE, null));
			
			return true;
		}
		
		ChessPieceColor chessPieceColor;
		if (coordinates.getX() < 2) {
			chessPieceColor = ChessPieceColor.BLACK;
		} else {
			chessPieceColor = ChessPieceColor.WHITE;
		}
		
		if (coordinates.getX() == 1 || coordinates.getX() == chessBoard.getMaxX() - 1) {
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.PAWN, chessPieceColor));
			return true;
		}
		
		if (coordinates.getY() == chessBoard.getMaxY() / 2) {
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.QUEEN, chessPieceColor));
		}
		
		if (coordinates.getY() == chessBoard.getMaxY() / 2 + 1) {
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.KING, chessPieceColor));
		}
		
		int y = coordinates.getY();
		
		if (y > chessBoard.getMaxY() / 2) {
			y = chessBoard.getMaxY() - y;
		}
		
		switch(y) {
		case 0: 
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.ROOK, chessPieceColor));
			break;
		case 1:
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.KNIGHT, chessPieceColor));
			break;
		case 2:
			chessBoard.setChessPieceAtCoordinate(coordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.BISHOP, chessPieceColor));
			break;
		}
		
		return true;
	}

}
