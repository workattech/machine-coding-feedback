package com.chessBoard.interfaces;

import java.util.Set;

import com.chessPiece.interfaces.IChessPiece;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;

public interface IChessBoard {
	IChessPiece getChessPieceAtCoordinate(Coordinates coordinates);
	
	int getMaxX();
	
	int getMaxY();
	
	boolean setChessPieceAtCoordinate(Coordinates coordinates, IChessPiece chessPiece);
	
	boolean instantiateBoard();
	
	boolean isValidMove(Coordinates startCoordinates, Coordinates endCoordinates);
	
	Set<Coordinates> getBlockedPositionsForKing(ChessPieceColor chessPieceColor);
	
	Coordinates getCoordinatesAtChessBoardObject(Coordinates coordinates);
	
	boolean isChecked(ChessPieceColor chessPieceColor);
}
