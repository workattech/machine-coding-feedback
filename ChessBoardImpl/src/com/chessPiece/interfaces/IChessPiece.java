package com.chessPiece.interfaces;

import java.util.Set;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public interface IChessPiece {
	boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard);
	
	ChessPieceType getChessPieceType();
	
	ChessPieceColor getChessPieceColor();
	
	Set<Coordinates> getAllPossibleNextCoordinates(IChessBoard chessBoard, Coordinates currentPosition);
	
	Set<Coordinates> getAllPossibleNextCoordinatesInDirection(IChessBoard chessBoard, Coordinates currentPosition, Direction direction);
}
