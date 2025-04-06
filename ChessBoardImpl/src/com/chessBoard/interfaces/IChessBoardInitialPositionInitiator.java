package com.chessBoard.interfaces;

import com.coordinates.Coordinates;

public interface IChessBoardInitialPositionInitiator {
	boolean setChessPieceAtCoordinate(Coordinates coordinates, IChessBoard chessBoard);
}
