package com.chess.interfaces;

import com.coordinates.Coordinates;

public interface IChessApplication {
	boolean makeAMove(Coordinates startCoordinates, Coordinates endCoordinates);
}
