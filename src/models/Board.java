package models;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board extends BaseModel {
	private final long size;
	private List<List<Cell>> board;
	private long tileCount;

	public Board(long size) {
		this.size = size;
		this.tileCount = 0;
		// create empty board of length 'size'
		List<List<Cell>> board = new ArrayList((int) size);
		for(int rowIdx = 0; rowIdx < this.size; rowIdx++) {
			board.add(new ArrayList((int) size));
			for(int colIdx = 0; colIdx < this.size; colIdx++) {
				board.get(rowIdx).add(new Cell(rowIdx, colIdx, null));
			}
		}
		this.board = board;
		// assign two random cells with tiles
		spawnTile(2);
		spawnTile(2);
	}

	private boolean isValidCellIndices(long rowIndex, long columnIndex) {
		return (rowIndex >= 0 && rowIndex < this.size) && (columnIndex >= 0 && columnIndex < this.size);
	}

	private void moveTiles(List<Cell> startCells, Direction direction) {
		for (Cell startCell : startCells) {
			List<Tile> tilesInSameDirection = new ArrayList<>();
			List<Cell> cellsInSameDirection = new ArrayList<>();
			for (long rowIdx = startCell.getRowIndex(), colIdx = startCell.getColumnIndex(); isValidCellIndices(rowIdx, colIdx); rowIdx += direction.getRowDelta(), colIdx += direction.getColumnDelta()) {
				Cell currentCell = this.getCell(rowIdx, colIdx);
				if (currentCell.getTile() != null) {
					Tile currentTile = currentCell.getTile();
					tilesInSameDirection.add(currentTile);
					cellsInSameDirection.add(currentCell);
				}
			}
			int listIndex = 0;
			if (tilesInSameDirection.size() == 0) continue;
			for (long rowIdx = startCell.getRowIndex(), colIdx = startCell.getColumnIndex(); isValidCellIndices(rowIdx, colIdx); rowIdx += direction.getRowDelta(), colIdx += direction.getColumnDelta()) {
				Cell currentCell = this.getCell(rowIdx, colIdx);
				if (currentCell.getTile() == null && listIndex < tilesInSameDirection.size()) {
					currentCell.setTile(tilesInSameDirection.get(listIndex));
					cellsInSameDirection.get(listIndex).setTile(null);
					if (listIndex >= tilesInSameDirection.size()) break;
				}
				listIndex++;
			}
		}
	}

	private void mergeTiles(List<Cell> startCells, Direction direction) {
		for (Cell startCell : startCells) {
			Cell lastUnmergedCell = null;
			for (long rowIdx = startCell.getRowIndex(), colIdx = startCell.getColumnIndex(); isValidCellIndices(rowIdx, colIdx); rowIdx += direction.getRowDelta(), colIdx += direction.getColumnDelta()) {
				Cell currentCell = this.getCell(rowIdx, colIdx);
				if (currentCell.getTile() != null) {
					if (lastUnmergedCell != null) {
						if (lastUnmergedCell.merge(currentCell)) {
							currentCell = null;
							tileCount--;
						}
					}
					lastUnmergedCell = currentCell;
				}
			}
		}
	}

	private void spawnTile(long number) {
		long emptyCellCount = this.size*this.size - tileCount;
		long randomTileNumberToSpawnTile = ThreadLocalRandom.current().nextInt(0, (int) emptyCellCount);
		for(int rowIdx = 0; rowIdx < this.size; rowIdx++) {
			for(int colIdx = 0; colIdx < this.size; colIdx++) {
				Cell currentCell = this.getCell(rowIdx, colIdx);
				Tile currentTile = currentCell.getTile();
				if(currentTile == null && randomTileNumberToSpawnTile-- == 0) {
					currentCell.setTile(new Tile(number));
				}
			}
		}
		tileCount++;
	}

	private List<Cell> getStartIndices(Direction direction) {
		List<Cell> startIndices = new ArrayList<>();
		for (long rowIndex = 0; rowIndex < this.size; rowIndex++) {
			for (long columnIndex = 0; columnIndex < this.size; columnIndex++) {
				if (!isValidCellIndices(rowIndex + direction.getRowDelta(), columnIndex + direction.getColumnDelta()))
					startIndices.add(getCell(rowIndex, columnIndex));
			}
		}
		return startIndices;
	}

	public boolean isBoardFull() {
		return this.size*this.size <= tileCount;
	}
	
	public void printBoard() {
		for (long rowIdx = 0; rowIdx < this.size; rowIdx++) {
			for (long colIdx = 0; colIdx < this.size; colIdx++) {
				if(this.getCell(rowIdx, colIdx).getTile() == null)
					System.out.print("*\t");
				else
					System.out.print(this.getCell(rowIdx, colIdx).getTile().getValue().getNumber() + "\t");
			}
			System.out.print("\n");
		}
	}

	public boolean hasMaxNumber() {
		boolean isMaxNumberPresent = false;
		for (long rowIdx = 0; rowIdx < this.size; rowIdx++) {
			for (long colIdx = 0; colIdx < this.size; colIdx++) {
				if(this.getCell(rowIdx, colIdx).getTile() != null && this.getCell(rowIdx, colIdx).getTile().getValue().getNumber() >= Math.pow(Value.baseNumber, Value.maxPower)) {
					isMaxNumberPresent = true;
				}
			}
		}
		return isMaxNumberPresent;
	}

	public void makeMove(GameTurn gameTurn) {
		Direction direction = gameTurn.getDirection();
		Direction oppositeDirection = new Direction(-direction.getRowDelta(), -direction.getColumnDelta());
		List<Cell> startIndices = getStartIndices(direction);
		mergeTiles(startIndices, oppositeDirection);
		moveTiles(startIndices, oppositeDirection);
		spawnTile(0);
	}

	public Cell getCell(long rowIndex, long columnIndex) {
		return this.board.get((int) rowIndex).get((int) columnIndex);
	}
}
