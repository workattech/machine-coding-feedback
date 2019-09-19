package model;

public class Board {
	
	int length;
	int width;
	int startPosition;
	int winningPosition;
	int diceCount;
	boolean repeatTurns;
	int maxRepeat;
	int repeatNumber;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	public int getWinningPosition() {
		return winningPosition;
	}
	public void setWinningPosition(int winningPosition) {
		this.winningPosition = winningPosition;
	}
	public int getDiceCount() {
		return diceCount;
	}
	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}
	public boolean isRepeatTurns() {
		return repeatTurns;
	}
	public void setRepeatTurns(boolean repeatTurns) {
		this.repeatTurns = repeatTurns;
	}
	public int getMaxRepeat() {
		return maxRepeat;
	}
	public void setMaxRepeat(int maxRepeat) {
		this.maxRepeat = maxRepeat;
	}
	public int getRepeatNumber() {
		return repeatNumber;
	}
	public void setRepeatNumber(int repeatNumber) {
		this.repeatNumber = repeatNumber;
	}
	
	

}
