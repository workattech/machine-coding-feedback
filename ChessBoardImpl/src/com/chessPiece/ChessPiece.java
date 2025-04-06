package com.chessPiece;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.chessBoard.interfaces.IChessBoard;
import com.chessPiece.interfaces.IChessPiece;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public abstract class ChessPiece implements IChessPiece {

	private ChessPieceType chessPieceType;
	
	private ChessPieceColor chessPieceColor;
	
	protected Set<Direction> possibleDirections;
	
	ChessPiece(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor) {
		this.chessPieceType = chessPieceType;
		this.instantiatePossibleDirections();
	}
	
	protected abstract void instantiatePossibleDirections();
	@Override
	public ChessPieceType getChessPieceType() {
		return this.chessPieceType;
	}

	@Override
	public ChessPieceColor getChessPieceColor() {
		// TODO Auto-generated method stub
		return this.chessPieceColor;
	}
	
	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		if (startPosition.getChessCellColor() != endPosition.getChessCellColor()) {
			return false;
		}
		
		Direction direction = this.getDirection(startPosition, endPosition);
		
		if (!this.possibleDirections.contains(direction)) {
			return false;
		}
		
		if (!this.isPathEmpty(startPosition, endPosition, direction, chessBoard)) {
			return false;
		}
		
		return false;
	}
	
	
	
	@Override
	public Set<Coordinates> getAllPossibleNextCoordinates(IChessBoard chessBoard, Coordinates currentPosition) {
		Set<Coordinates> coordinateList = new HashSet<>();
		
		Iterator<Direction> it = this.possibleDirections.iterator();
		
		while (it.hasNext()) {
			Direction direction = it.next();
			Set<Coordinates> directionCoordinates = this.getAllPossibleNextCoordinatesInDirection(chessBoard, currentPosition, direction);
			
			if (directionCoordinates != null) {
				coordinateList.addAll(directionCoordinates);
			}
		}
		
		return coordinateList;
 	}
	
	

	@Override
	public Set<Coordinates> getAllPossibleNextCoordinatesInDirection(IChessBoard chessBoard,
			Coordinates currentPosition, Direction direction) {
		Set<Coordinates> coordinateList = new HashSet<>();
		Coordinates tracker = new Coordinates(currentPosition.getX(), currentPosition.getY(), null);
		
		if (direction == Direction.RANDOM) {
			return null;
		}
		
		tracker = this.updateNextPosition(tracker, direction);
		while (tracker.getX() < chessBoard.getMaxX() && tracker.getY() < chessBoard.getMaxY() && tracker.getX() >= 0 && tracker.getY() >= 0) {

			coordinateList.add(chessBoard.getCoordinatesAtChessBoardObject(tracker));
			
			if (chessBoard.getChessPieceAtCoordinate(tracker).getChessPieceType() != ChessPieceType.NONE) {
				break;
			}
			
			
			tracker = this.updateNextPosition(tracker, direction);
		}
		
		return coordinateList;
	}

	protected Direction getDirection(Coordinates startCoordinates, Coordinates endCoordinates) {
		int diffX = startCoordinates.getX() - endCoordinates.getX();
		
		int diffY = startCoordinates.getY() - endCoordinates.getY();
		
		if (diffX != 0 && diffY != 0 && this.getAbsValue(diffY) != this.getAbsValue(diffX)) {
			return Direction.RANDOM;
		}
		
		if (diffX < 0 && diffY < 0) {
			return Direction.LEFT_UP;
		} else if (diffX < 0 && diffY == 0) {
			return Direction.UP;
		} else if (diffX < 0) {
			return Direction.RIGHT_UP;
		} else if (diffX == 0 && diffY < 0) {
			return Direction.LEFT;
		} else if (diffX == 0) {
			return Direction.RIGHT;
		} else if (diffX > 0 && diffY > 0) {
			return Direction.RIGHT_DOWN;
		} else if (diffX > 0 && diffY == 0) {
			return Direction.DOWN;
		} else {
			return Direction.LEFT_DOWN;
		}
	}
	
	protected boolean isPathEmpty(Coordinates startPosition, Coordinates endPosition, Direction direction, IChessBoard chessBoard) {
		if (direction == Direction.RANDOM) {
			return true;
		}
		Coordinates tracker = new Coordinates(startPosition.getX(), startPosition.getY(), null);
		
		tracker = this.updateNextPosition(tracker, direction);
		while (tracker.getX() != endPosition.getX() && tracker.getY() != endPosition.getY()) {
			if (chessBoard.getChessPieceAtCoordinate(tracker).getChessPieceType() != ChessPieceType.NONE) {
				return false;
			}
			
			tracker = this.updateNextPosition(tracker, direction);
		}
		
		return true;
	}
	
	private Coordinates updateNextPosition(Coordinates tracker, Direction direction) {
		int newX = tracker.getX();
		
		int newY = tracker.getY();
		
		switch (direction) {
		case DOWN:
			newX++;
			break;
		case LEFT:
			newY--;
			break;
		case LEFT_DOWN:
			newY--;
			newX++;
			break;
		case LEFT_UP:
			newY--;
			newX--;
			break;
		case RIGHT:
			newY++;
			break;
		case RIGHT_DOWN:
			newY++;
			newX++;
			break;
		case RIGHT_UP:
			newY++;
			newX--;
			break;
		case UP:
			newX--;
			break;
		default:
			break;
		}
		
		return new Coordinates(newX, newY, null);
		
	}

	protected int getAbsValue(int number) {
		if (number < 0) {
			return number * -1;
		}
		
		return number;
	}
	
	
	
	
}
