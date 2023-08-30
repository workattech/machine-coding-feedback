package com.pankaj.tictactoegame.models;

public class Cell {
	public Cell() {
		this.player = null;
		this.isOccupied = false;
		this.type = '-';
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public boolean getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	private Player player;
	private boolean isOccupied;
	private char type;
	
	public void performMove(Player player) {
		this.isOccupied = true;
		this.type = player.getType();
		this.player = player;
		player.setMovestaken(this.player.getMovestaken() + 1);
	}
	
	public char cellValue() {
		return type;
	}
}
