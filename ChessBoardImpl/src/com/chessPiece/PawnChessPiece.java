package com.chessPiece;

import com.chessBoard.interfaces.IChessBoard;
import com.coordinates.Coordinates;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;
import com.enums.Direction;

public class PawnChessPiece extends ChessPiece {
	
	

	public PawnChessPiece(ChessPieceColor chessPieceColor) {
		super(ChessPieceType.PAWN, chessPieceColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Coordinates startPosition, Coordinates endPosition, IChessBoard chessBoard) {
		if (!super.isValidMove(startPosition, endPosition, chessBoard)) {
			return false;
		}
		
		Direction direction = this.getDirection(startPosition, endPosition);
		
		if (direction == Direction.DOWN || direction == Direction.UP) {
			int absDiff = this.getAbsValue(startPosition.getX() - endPosition.getX());
			
			int boardStartPos; 
			
			if (this.getChessPieceColor() == ChessPieceColor.BLACK) {
				boardStartPos = 1;
			} else {
				boardStartPos = chessBoard.getMaxX() - 2;
			}
			
			if (startPosition.getX() == boardStartPos && (absDiff > 2)) {
				return false;
			} else if (startPosition.getX() != boardStartPos && absDiff > 1) {
				return false;
			}
			if (chessBoard.getChessPieceAtCoordinate(endPosition).getChessPieceType() != ChessPieceType.NONE) {
				return false;
			}
			
			return true;
		}
		
		int absDiffX = this.getAbsValue(startPosition.getX() - endPosition.getX());
		
		int absDiffY = this.getAbsValue(endPosition.getY() - endPosition.getY());
		
		if (absDiffX != 1 || absDiffY != 1) {
			return false;
		}
		
		if (chessBoard.getChessPieceAtCoordinate(endPosition).getChessPieceType() == ChessPieceType.NONE || chessBoard.getChessPieceAtCoordinate(endPosition).getChessPieceColor() == this.getChessPieceColor()) {
			return false;
		}
		
		return true;
		
	}

	@Override
	protected void instantiatePossibleDirections() {
		if (this.getChessPieceColor() == ChessPieceColor.BLACK) {
			this.possibleDirections.add(Direction.DOWN);
			this.possibleDirections.add(Direction.LEFT_DOWN);
			this.possibleDirections.add(Direction.RIGHT_DOWN);
		} else {
			this.possibleDirections.add(Direction.UP);
			this.possibleDirections.add(Direction.LEFT_UP);
			this.possibleDirections.add(Direction.RIGHT_UP);
		}
	}

}
