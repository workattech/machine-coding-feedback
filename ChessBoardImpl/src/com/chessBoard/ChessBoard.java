package com.chessBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chessBoard.interfaces.IChessBoard;
import com.chessBoard.interfaces.IChessBoardInitialPositionInitiator;
import com.chessPiece.interfaces.IChessPiece;
import com.chessPiece.interfaces.IChessPieceFactory;
import com.coordinates.Coordinates;
import com.enums.ChessCellColor;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;

public class ChessBoard implements IChessBoard {
	
	private static int DEFAULT_MAX_X = 8;
	
	private static int DEFAULT_MAX_Y = 8;
	
	private static ChessPieceColor DEFAULT_START_CHANCE_BY = ChessPieceColor.WHITE;
	
	private Map<Coordinates, Set<Coordinates>> attacksMap;
	
	private Map<Coordinates, Set<Coordinates>> attackedByMap;
	
	private Map<Coordinates, IChessPiece> coordinateMap;
	
	private List<List<Coordinates>> coordinatesMatrix;
	
	private ChessPieceColor currentChanceBy;
	
	private Map<ChessPieceColor, Set<Coordinates>> blockedPositionsForKing;
	
	private int maxX;
	
	private int maxY;
	
	private IChessBoardInitialPositionInitiator chessBoardInitialPositionInitiator;
	
	private Map<ChessPieceColor, Set<Coordinates>> checkMap;
	
	private IChessPieceFactory chessPieceFactory;
	
	private Map<ChessPieceColor, Coordinates> currentPositionOfKingMap;
	

	public ChessBoard(IChessBoardInitialPositionInitiator chessBoardInitialPositionInitiator, IChessPieceFactory chessPieceFactory) {
		this(ChessBoard.DEFAULT_MAX_X, ChessBoard.DEFAULT_MAX_Y, chessBoardInitialPositionInitiator, chessPieceFactory);
	}
	
	

	public ChessBoard(int maxX, int maxY, IChessBoardInitialPositionInitiator chessBoardInitialPositionInitiator, IChessPieceFactory chessPieceFactory) {
		this(ChessBoard.DEFAULT_START_CHANCE_BY, maxX, maxY, chessBoardInitialPositionInitiator, chessPieceFactory);
	}
	

	public ChessBoard(ChessPieceColor currentChanceBy, int maxX, int maxY,
			IChessBoardInitialPositionInitiator chessBoardInitialPositionInitiator, IChessPieceFactory chessPieceFactory) {
		this.currentChanceBy = currentChanceBy;
		this.maxX = maxX;
		this.maxY = maxY;
		this.chessBoardInitialPositionInitiator = chessBoardInitialPositionInitiator;
		this.chessPieceFactory = chessPieceFactory;
		this.instantiateBoard();
	}



	@Override
	public IChessPiece getChessPieceAtCoordinate(Coordinates coordinates) {
		// TODO Auto-generated method stub
		return this.coordinateMap.get(this.getCoordinatesAtChessBoardObject(coordinates));
	}

	@Override
	public int getMaxX() {
		return this.maxX;
	}

	@Override
	public int getMaxY() {
		// TODO Auto-generated method stub
		return this.maxY;
	}

	@Override
	public boolean instantiateBoard() {
		int i = 0;
		
		this.coordinateMap = new HashMap<>();
		
		this.attackedByMap = new HashMap<>();
		
		this.attacksMap = new HashMap<>();
		
		this.blockedPositionsForKing = new HashMap<>();
		
		this.blockedPositionsForKing.put(ChessPieceColor.BLACK, new HashSet<>());
		
		this.blockedPositionsForKing.put(ChessPieceColor.WHITE, new HashSet<>());
		
		this.checkMap = new HashMap<>();
		
		this.checkMap.put(ChessPieceColor.BLACK, new HashSet<>());
		
		this.checkMap.put(ChessPieceColor.WHITE, new HashSet<>());
		
		this.coordinatesMatrix = new ArrayList<>();
		
		while (i < this.maxX) {
			int j = 0;
			
			ChessCellColor chessCellColor = ChessCellColor.BLACK;
			
			if (i % 2 == 1) {
				chessCellColor = ChessCellColor.WHITE;
			}
			
			while (j < this.maxY) {
				if (this.coordinatesMatrix.size() <= i) {
					this.coordinatesMatrix.add(new ArrayList<Coordinates>());
				}
				
				if (j % 2 == 1) {
					this.coordinatesMatrix.get(i).add(new Coordinates(i, j, chessCellColor == ChessCellColor.BLACK ? ChessCellColor.WHITE : ChessCellColor.BLACK));
				} else {
					this.coordinatesMatrix.get(i).add(new Coordinates(i, j, chessCellColor));
				}
				
				this.chessBoardInitialPositionInitiator.setChessPieceAtCoordinate(this.coordinatesMatrix.get(i).get(j), this);
				j++;
			}
			
			i++;
		}
		
		this.currentPositionOfKingMap = new HashMap<>();
		
		this.currentPositionOfKingMap.put(ChessPieceColor.BLACK, this.coordinatesMatrix.get(0).get(maxY / 2));
		
		this.currentPositionOfKingMap.put(ChessPieceColor.WHITE, this.coordinatesMatrix.get(maxX - 1).get(maxY / 2));
		
		return true;
		
	}

	@Override
	public boolean setChessPieceAtCoordinate(Coordinates coordinates, IChessPiece chessPiece) {
		if (this.coordinateMap == null) {
			this.coordinateMap = new HashMap<>();
		}
		Coordinates currentCoordinates = this.getCoordinatesAtChessBoardObject(coordinates);
		
		if (this.coordinateMap.get(currentCoordinates).getChessPieceType() != ChessPieceType.NONE) {
			this.setChessPieceAtCoordinate(currentCoordinates, this.chessPieceFactory.createChessPiece(ChessPieceType.NONE, ChessPieceColor.NONE));
		}
		
		if (chessPiece.getChessPieceType() == ChessPieceType.NONE) {	
			Set<Coordinates> attacks = this.attacksMap.get(currentCoordinates);
			
			attacks.remove(currentCoordinates);
			
			Iterator<Coordinates> it = attacks.iterator();
			
			while (it.hasNext()) {
				this.attackedByMap.get(it.next()).remove(currentCoordinates);
			}
			
			this.coordinateMap.put(currentCoordinates, chessPiece);
			return true;
		}
		
		this.coordinateMap.put(currentCoordinates, chessPiece);
		
		Set<Coordinates> attacks = chessPiece.getAllPossibleNextCoordinates(this, currentCoordinates);
		
		Iterator<Coordinates> it = attacks.iterator();
		
		while (it.hasNext()) {
			Coordinates next = it.next();
			
			if (!this.attacksMap.containsKey(currentCoordinates)) {
				this.attacksMap.put(currentCoordinates, new HashSet<>());
			}
			
			this.attacksMap.get(currentCoordinates).add(next);
			
			if (!this.attackedByMap.containsKey(next)) {
				this.attackedByMap.put(next, new HashSet<>());
			}
			
			this.attackedByMap.get(next).add(currentCoordinates);
			
			
		}
		
		
		return true;
	}

	@Override
	public boolean isValidMove(Coordinates startCoordinates, Coordinates endCoordinates) {
		if (startCoordinates.getX() < 0 || startCoordinates.getY() < 0 || startCoordinates.getX() >= this.getMaxX() || startCoordinates.getY() >= this.getMaxY()) {
			return false;
		}
		
		if (endCoordinates.getX() < 0 || endCoordinates.getY() < 0 || endCoordinates.getX() >= this.getMaxX() || endCoordinates.getY() >= this.getMaxY()) {
			return false;
		}
		
		Coordinates start = this.coordinatesMatrix.get(startCoordinates.getX()).get(startCoordinates.getY());
		
		Coordinates end = this.coordinatesMatrix.get(endCoordinates.getX()).get(endCoordinates.getY());
		
		if (this.coordinateMap.get(start).getChessPieceColor() != this.currentChanceBy) {
			return false;
		}
		
		if (this.coordinateMap.get(start).getChessPieceColor() == this.coordinateMap.get(end).getChessPieceColor()) {
			return false;
		}
		
		return this.coordinateMap.get(start).isValidMove(start, end, this);
	}



	@Override
	public Set<Coordinates> getBlockedPositionsForKing(ChessPieceColor chessPieceColor) {
		return this.blockedPositionsForKing.get(chessPieceColor);
	}



	@Override
	public Coordinates getCoordinatesAtChessBoardObject(Coordinates coordinates) {
		return this.coordinatesMatrix.get(coordinates.getX()).get(coordinates.getY());
	}



	@Override
	public boolean isChecked(ChessPieceColor chessPieceColor) {
		if (this.checkMap.get(chessPieceColor) != null && this.checkMap.get(chessPieceColor).size() > 0) {
			return true;
		}
		
		return false;
	}

}
